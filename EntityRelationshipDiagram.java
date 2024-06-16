import java.util.ArrayList;
import java.util.List;

public class EntityRelationshipDiagram {

    private final List<Entity> entities;
    private final List<Relationship> relationships;

    public EntityRelationshipDiagram() {
        entities = new ArrayList<>();
        relationships = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public static void main(String[] args) {
        EntityRelationshipDiagram erd = new EntityRelationshipDiagram();

        // Create entities
        Entity customer = new Entity("Customer");
        Entity order = new Entity("Order");
        Entity product = new Entity("Product");

        // Add entities to the ER diagram
        erd.addEntity(customer);
        erd.addEntity(order);
        erd.addEntity(product);

        // Create relationships
        Relationship customerOrderRelationship = new Relationship(customer, order, "1:N");
        Relationship orderProductRelationship = new Relationship(order, product, "N:M");

        // Add relationships to the ER diagram
        erd.addRelationship(customerOrderRelationship);
        erd.addRelationship(orderProductRelationship);

        // Print the ER diagram
        System.out.println(erd);
    }
}

class Entity {

    private final String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Relationship {

    private final Entity source;
    private final Entity target;
    private final String cardinality;

    public Relationship(Entity source, Entity target, String cardinality) {
        this.source = source;
        this.target = target;
        this.cardinality = cardinality;
    }

    public Entity getSource() {
        return source;
    }

    public Entity getTarget() {
        return target;
    }

    public String getCardinality() {
        return cardinality;
    }

    @Override
    public String toString() {
        return source.getName() + " " + cardinality + " " + target.getName();
    }
}