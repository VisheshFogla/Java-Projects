/**
 * 
 */
package binarySearchTree;

/**
 * @author Vishesh
 * @version 5.2.2020
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private String lastName;
    private String phoneNumber;

    /**
     * 
     * @param enterName
     *            enter the firstName of the person.
     * @param enterLastName
     *            enter the lastName of the person
     * @param contactNumber
     *            enter the contact number of the person.
     */
    public Contact(
        String enterName,
        String enterLastName,
        String contactNumber) {
        name = enterName;
        lastName = enterLastName;
        phoneNumber = contactNumber;
    }


    /**
     * 
     */
    @Override
    public int compareTo(Contact other) {

        if (this.lastName.compareTo(other.lastName) < 0) {
            return -1;
        }
        else if (this.lastName.compareTo(other.lastName) > 0) {
            return 1;
        }
        else {
            if (this.name.compareTo(other.name) < 0) {
                return -1;
            }
            else if (this.name.compareTo(other.name) > 0) {
                return 1;
            }
            else {
                if (this.phoneNumber.compareTo(other.phoneNumber) < 0) {
                    return -1;
                }
                else if (this.phoneNumber.compareTo(other.phoneNumber) > 0) {
                    return 1;
                }

                return 0;
            }
        }

    }

}
