package testDDL;
import java.io.File;
 
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
 
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.reflections.Reflections;

public class Hibernate5DDLExporter {
 
    private String dialect = "org.hibernate.dialect.Oracle10gDialect";
    private String[] entityPackages;
 
    public Hibernate5DDLExporter dialect(String dialect) {
        this.dialect = dialect;
        return this;
    }
 
    public Hibernate5DDLExporter entities(String... entityPackage) {
        this.entityPackages = entityPackage;
        return this;
    }
 
    public Hibernate5DDLExporter schemaExport(String fileName, String targetDirectory) throws Exception {
        if (entityPackages == null && entityPackages.length == 0) {
            System.out.println("Not packages selected");
            System.exit(0);
        }
        File exportFile = createExportFileAndMakeDirectory(fileName, targetDirectory);
 
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySetting(AvailableSettings.DIALECT, dialect)
                .build();
 
        MetadataImplementor metadata = (MetadataImplementor) mapAnnotatedClasses(serviceRegistry).buildMetadata();
 
        SchemaExport schemaExport = new SchemaExport(metadata);
        schemaExport.setOutputFile(exportFile.getAbsolutePath());
        schemaExport.setDelimiter(";");
        schemaExport.setFormat(true);
        schemaExport.execute(true, false, false, true);
        ((StandardServiceRegistryImpl) serviceRegistry).destroy();
 
        System.out.println(exportFile.getAbsolutePath());
 
        return this;
 
    }
 
    private File createExportFileAndMakeDirectory(String fileName, String targetDirectory) {
        File exportFile;
        if (targetDirectory != null) {
            final File directory = new File(targetDirectory);
            directory.mkdirs();
            exportFile = new File(directory, fileName);
        } else {
            exportFile = new File(fileName);
        }
        return exportFile;
    }
 
    private MetadataSources mapAnnotatedClasses(ServiceRegistry serviceRegistry) {
        MetadataSources sources = new MetadataSources(serviceRegistry);
 
        final Reflections reflections = new Reflections((Object) entityPackages);
        for (final Class<?> mappedSuperClass : reflections.getTypesAnnotatedWith(MappedSuperclass.class)) {
            sources.addAnnotatedClass(mappedSuperClass);
            System.out.println("Mapped = " + mappedSuperClass.getName());
        }
        for (final Class<?> entityClasses : reflections.getTypesAnnotatedWith(Entity.class)) {
            sources.addAnnotatedClass(entityClasses);
            System.out.println("Mapped = " + entityClasses.getName());
        }
        return sources;
    }
 
    public static Hibernate5DDLExporter instance() {
        return new Hibernate5DDLExporter();
    }
 
    public static void main(String[] args) throws Exception {
//        Hibernate5DDLExporter.instance()
//                .entities("schema")
//                .schemaExport("create.sql", "build");
        
        Hibernate5DDLExporter.instance()
        .entities("entity")
        .schemaExport("create.sql", "build");
    }
}