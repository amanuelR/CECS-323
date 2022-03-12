package csulb.cecs323.model;

import javax.persistence.*;

/**
 * Individual, physical automobiles that someone can drive on land to transport one or more passengers
 * and a limited amount of cargo around.  Cars have four wheels and usually travel on paved roads.
 */
@Entity
public class Cars {
    /** The unique ID of the vehicle.  Limited to 17 characters. */
    @Id
    @Column(nullable = false, length = 17)
    private String VIN;

    /** The name of the corporation which manufactured the vehicle.  Limited to 40 characters. */
    @Column(nullable = false, length = 40)
    private String manufacturer;

    /** The popular name of the vehicle, like the Prius for Toyota.  Limited to 20 characters. */
    @Column(nullable = false, length = 20)
    private String model;

    /** The year that the vehicle was manufactured.  For now, do not worry about validating this #. */
    @Column(nullable = false)
    private int model_year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName ="owner_id", nullable = false)
    private Owners owners;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_body_style_name", referencedColumnName ="name", nullable = false)
    private auto_body_styles auto_body_styles;

    /**A Cars constructor that takes five arguments(attributes)**/
    public Cars(Owners owners, auto_body_styles auto_body_styles, String VIN, String manufacturer,
                String model, int model_year){
                this.owners = owners;
                this.auto_body_styles = auto_body_styles ;
                this.VIN = VIN;
                this.manufacturer = manufacturer;
                this.model = model;
                this.model_year = model_year;
    }

    /** Default constructor for Cars **/
    public Cars(){}

    /** setter and getter methods for all attributes of Cars **/
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public Owners getOwners() {
        return owners;
    }

    public void setOwners(Owners owners) {
        this.owners = owners;
    }

    public auto_body_styles getAutoBodyStyles() {
        return auto_body_styles ;
    }

    public void setAutoBodyStyles(auto_body_styles autoBodyStyles) {
        this.auto_body_styles  = autoBodyStyles;
    }

    @Override
    public String toString () {
        return "Cars - VIN: " + this.VIN + " Manufacturer: " + this.manufacturer +
                " Model: " + this.model + " year: " + this.model_year;
    }
}
