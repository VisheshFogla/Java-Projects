/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * 
 */
package spacecolonies;

/**
 * @author Vishesh
 * @version 19.04.2020
 * 
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * constructor. Skills are between 1 and 5.
     * 
     * @param ag
     *            agriculture;
     * @param med
     *            medicine;
     * @param tech
     *            technology;
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * see if skills are lower
     * 
     * @param other
     *            the other skills
     * @return if skills are lower/equal
     */
    public boolean isBelow(Skills other) {
        return (agriculture <= other.agriculture && medicine <= other.medicine
            && technology <= other.technology);
    }


    /**
     * see if two skills are equal
     * 
     * @param obj
     *            the other skill
     * @return true/false
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return (agriculture == ((Skills)obj).getAgriculture()
            && medicine == ((Skills)obj).getMedicine()
            && technology == ((Skills)obj).getTechnology());
    }


    /**
     * get ag
     * 
     * @return ag
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * get med
     * 
     * @return med
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * get tech
     * 
     * @return tech
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * 
     * The method gives the string value of skills.
     * 
     * @return string value of skills.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("A:");
        sb.append(agriculture);
        sb.append(" M:");
        sb.append(medicine);
        sb.append(" T:");
        sb.append(technology);
        return sb.toString();
    }
}
