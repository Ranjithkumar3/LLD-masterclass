import oops.encapsulation.Person;
import oops.encapsulation.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncapsulationTest {
    @Test
    void personPropertyTest() {
        Person person = new Person("Ranjith");

        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
        assertThrows(IllegalArgumentException.class, () -> person.setWeight(-4));

        person.setAge(20);
        person.setWeight(70);

        Property person1Prop = new Property();
        person1Prop.setBankBalance(20000);
        person1Prop.setProperties(1);
        person.setProperty(person1Prop);

        assertEquals(20, person.getAge());
        assertEquals(70, person.getWeight());
        assertEquals(20000, person.getProperty().getBankBalance());
        assertEquals(1, person.getProperty().getProperties());
    }
}
