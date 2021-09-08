/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)
package spacecolonies;

/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;

    /**
     * Person constructor (calls Skills constructor)
     * 
     * @param name
     *            String name
     * @param agri
     *            int ag
     * @param medi
     *            int med
     * @param tech
     *            int tech
     * @param planet
     *            String planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        skills = new Skills(agri, medi, tech);
        this.name = name;
        planetPreference = planet;
    }


    /**
     * get skill
     * 
     * @return
     *         skill
     */
    public Skills getSkills() {
        return skills;

    }


    /**
     * get name
     * 
     * @return
     *         name
     */
    public String getName() {
        return name;

    }


    /**
     * get planet name that the person wants
     * 
     * @return
     *         planet
     */
    public String getPlanetName() {
        return planetPreference;

    }


    /**
     * to string. ("No-planet" is before anything else)
     * 
     * @return
     *         string version
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (planetPreference.length() <= 0) {
            sb.append("No-Planet ");
        }
        sb.append(name);
        sb.append(" A:");
        sb.append(skills.getAgriculture());
        sb.append(" M:");
        sb.append(skills.getMedicine());
        sb.append(" T:");
        sb.append(skills.getTechnology());
        if (planetPreference.length() > 0) {
            sb.append(" Wants: ");
            sb.append(planetPreference);
        }
        return sb.toString();
    }


    /**
     * The method sees if the two persons are equal or not. Two Person objects
     * are equal when their name, skills, and planet preference value
     * is the same.
     * 
     * @param obj
     *            takes a person object and compares it with the another.
     * 
     * @return a boolean value indicating whether the object is equal or not.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (this.getClass() == obj.getClass()) {
            Person other = (Person)obj;
            if (this.name == other.getName() && this.getSkills().equals(other
                .getSkills()) && this.planetPreference == other
                    .getPlanetName()) {
                return true;
            }

        }

        return false;

    }
}
