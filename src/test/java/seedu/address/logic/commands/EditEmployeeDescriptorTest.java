package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEPARTMENT_LOGISTIC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LEAVE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SALARY_BOB;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditEmployeeDescriptor;
import seedu.address.testutil.EditEmployeeDescriptorBuilder;

public class EditEmployeeDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditEmployeeDescriptor descriptorWithSameValues = new EditCommand.EditEmployeeDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditEmployeeDescriptor editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different salary -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withSalary(VALID_SALARY_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different leave -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withLeave(VALID_LEAVE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different departments -> returns false
        editedAmy = new EditEmployeeDescriptorBuilder(DESC_AMY).withDepartments(VALID_DEPARTMENT_LOGISTIC).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditCommand.EditEmployeeDescriptor editEmployeeDescriptor = new EditCommand.EditEmployeeDescriptor();
        String expected = EditCommand.EditEmployeeDescriptor.class.getCanonicalName()
                + "{name=" + editEmployeeDescriptor.getName().orElse(null)
                + ", phone=" + editEmployeeDescriptor.getPhone().orElse(null)
                + ", email=" + editEmployeeDescriptor.getEmail().orElse(null)
                + ", address=" + editEmployeeDescriptor.getAddress().orElse(null)
                + ", salary=" + editEmployeeDescriptor.getSalary().orElse(null)
                + ", leave=" + editEmployeeDescriptor.getLeave().orElse(null)
                + ", departments=" + editEmployeeDescriptor.getDepartments().orElse(null) + "}";
        assertEquals(expected, editEmployeeDescriptor.toString());
    }
}
