package com.yates.proyecto_yates;

import com.yates.proyecto_yates.model.TipoUsuario;
import com.yates.proyecto_yates.model.entity.AmarreEntity;
import com.yates.proyecto_yates.model.entity.TipoYateEntity;
import com.yates.proyecto_yates.model.entity.UsuarioEntity;
import com.yates.proyecto_yates.model.entity.VentaEntity;
import com.yates.proyecto_yates.model.entity.YateEntity;
import com.yates.proyecto_yates.model.entity.ZonaEntity;
import com.yates.proyecto_yates.model.repositorys.config.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class EjemploDB {

    // Nombre de la Unidad de Persistencia (debe coincidir con persistence.xml)
    private static final String PERSISTENCE_UNIT_NAME = "mi-unidad-puerto";

    public static void main(String[] args) {

        EntityManager em = null;

        try {
            em = JpaUtil.getEntityManager();

            // 2. Iniciar la Transacción (Todo o Nada)
            em.getTransaction().begin();
            System.out.println("🚀 Iniciando la carga de datos en una transacción...");

            // --- EJECUTAR CADA BLOQUE DE INSERCIÓN ---
            insertZonas(em);
            insertTipoYate(em);
            // insertOcupar(em); // No sé qué es "ocupar", la omito.
            insertUsuarios(em);
            // insertEmpleados(em); // Entidad Empleado no proporcionada, la omito.
            insertAmarres(em);
            insertYates(em);
            //insertVentas(em);

            // 3. Commit (Si todo sale bien)
            em.getTransaction().commit();
            System.out.println("✅ Todos los datos cargados exitosamente. ¡GG!");

        } catch (Exception e) {
            // 4. Rollback (Si algo falla)
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.err.println("❌ Error fatal. Se ha revertido la transacción.");
            }
            e.printStackTrace();
        } finally {
            // 5. Cerrar recursos
            if (em != null) {
                em.close();
            }
        }
    }

    // ------------------------------------------------------------------
    // Bloques de inserción, mapeando los datos de SQL a objetos Java.
    // ------------------------------------------------------------------
    private static void insertZonas(EntityManager em) {
        System.out.println("-> Insertando Zonas...");
        // Zona A
        ZonaEntity zA = new ZonaEntity();
        zA.setId_zona('A'); // Usa Character
        zA.setCuota_administracion(350000.00);
        zA.setCapacidad(20);
        zA.setProfundidad(5.50);
        zA.setDim_max_eslora(12.00);
        zA.setDim_max_manga(4.50);
        zA.setDim_max_calado(2.50);
        zA.setDim_min_eslora(6.00);
        zA.setDim_min_manga(2.00);
        zA.setDim_min_calado(1.50);
        em.persist(zA);

        // Zona B (Abreviado para el ejemplo)
        ZonaEntity zB = new ZonaEntity();
        zB.setId_zona('B');
        zB.setCuota_administracion(280000.00);
        zB.setCapacidad(15);
        zB.setProfundidad(4.80);
        zB.setDim_max_eslora(10.00);
        zB.setDim_max_manga(3.80);
        zB.setDim_max_calado(2.00);
        zB.setDim_min_eslora(5.00);
        zB.setDim_min_manga(1.80);
        zB.setDim_min_calado(1.20);
        em.persist(zB);

        // ... (Se necesitaría insertar todas las zonas C-J)
    }

    private static void insertTipoYate(EntityManager em) {
        System.out.println("-> Insertando Tipos de Yate...");
        TipoYateEntity t1 = new TipoYateEntity();
        t1.setNombre("Velero");
        t1.setDescripcion("Yate impulsado principalmente por velas...");
        em.persist(t1);

        TipoYateEntity t2 = new TipoYateEntity();
        t2.setNombre("Catamarán");
        t2.setDescripcion("Embarcación de dos cascos que ofrece gran estabilidad...");
        em.persist(t2);

        // ... (Se necesitaría insertar todos los tipos)
    }

    private static void insertUsuarios(EntityManager em) {
        System.out.println("-> Insertando Usuarios...");

        // Usuario 1: ADMIN
        UsuarioEntity u1 = new UsuarioEntity();
        u1.setCedula("1001001001");
        u1.setNombre("Carlos Mendoza");
        u1.setDireccion("Cra 45 #12-30");
        u1.setTelefono("3001234567");
        u1.setMail("carlos.mendoza@example.com");
        u1.setContrasena("hash_contrasena_1"); // ¡Recuerda hashear esto!
        u1.setFechaVinculacion(LocalDate.parse("2023-01-10"));
        u1.setTipoUsuario(TipoUsuario.ADMIN); // Usando el Enum
        em.persist(u1);

        // Usuario 2: SOCIO
        UsuarioEntity u2 = new UsuarioEntity();
        u2.setCedula("1002002002");
        u2.setNombre("Laura Hernández");
        u2.setMail("laura.hernandez@example.com");
        u2.setContrasena("hash_contrasena_2");
        u2.setFechaVinculacion(LocalDate.parse("2022-11-05"));
        u2.setTipoUsuario(TipoUsuario.NORMAL);
        // ... (Faltan direccion y telefono en este ejemplo resumido)
        em.persist(u2);

        // ... (Se necesitaría insertar todos los usuarios)
    }

    private static void insertAmarres(EntityManager em) {
        System.out.println("-> Insertando Amarres...");

        // Recuperar entidades necesarias antes de insertar Amarre
        ZonaEntity zA = em.find(ZonaEntity.class, 'A');
        UsuarioEntity u1 = em.find(UsuarioEntity.class, "1001001001");

        // Amarre 1 (con el campo 'usuario' que decidiste mantener)
        AmarreEntity a1 = new AmarreEntity();
        // ID es autogenerado (no lo seteamos, a menos que quieras forzarlo, 
        // pero por convención IDENTITY lo maneja la DB)

        // a1.setNum_amarre(1L); // Si tu DB no usa autoincremental
        a1.setZona(zA);
        // a1.setFecha_compra(LocalDate.parse("2023-02-10")); // ¡Campo que eliminamos!
        em.persist(a1);

        // ...
    }

    private static void insertYates(EntityManager em) {
        System.out.println("-> Insertando Yates...");
        // Recuperar entidades necesarias
        UsuarioEntity u1 = em.find(UsuarioEntity.class, "1001001001");
        TipoYateEntity t1 = (TipoYateEntity) em.createQuery("SELECT t FROM TipoYateEntity t WHERE t.nombre = 'Velero'").getSingleResult();

        YateEntity y1 = new YateEntity();
        y1.setMatricula("MAT-0001");
        y1.setNombre("Tridente Azul");
        y1.setEslora(10.50);
        y1.setManga(3.20);
        y1.setCalado(1.80);
        y1.setDueno(u1); // Usuario 1 es el dueño
        y1.setTipoYate(t1); // Tipo: Velero
        // y1.setColor(color); // Campo 'color' no especificado en el INSERT de ejemplo
        em.persist(y1);

        // ...
    }

    private static void insertVentas(EntityManager em) {
        System.out.println("-> Insertando Ventas...");

        // Recuperar entidades necesarias
        UsuarioEntity u1 = em.find(UsuarioEntity.class, "1001001001"); // Vendedor 1 y Comprador 2
        UsuarioEntity u2 = em.find(UsuarioEntity.class, "1002002002");
        AmarreEntity a1 = em.find(AmarreEntity.class, 1L); // Amarre 1

        // Venta 1: Vendedor u1 -> Comprador u2
        VentaEntity v1 = new VentaEntity();
        v1.setFecha(LocalDate.parse("2023-03-10"));
        v1.setMonto(8500000.00);
        v1.setAmarre(a1);
        v1.setVendedor(u1);
        v1.setComprador(u2);
        em.persist(v1);

        // Venta 2: Vendedor u2 -> Comprador u3 (simulando una reventa)
        UsuarioEntity u3 = em.find(UsuarioEntity.class, "1003003003");
        AmarreEntity a2 = em.find(AmarreEntity.class, 2L);

        VentaEntity v2 = new VentaEntity();
        v2.setFecha(LocalDate.parse("2022-11-22"));
        v2.setMonto(9200000.00);
        v2.setAmarre(a2);
        v2.setVendedor(u2);
        v2.setComprador(u3);
        em.persist(v2);
    }
}
