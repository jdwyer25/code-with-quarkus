package Models;

/**
 * A sku
 */
public class SkuDomainModel {

    /**
     * The sku's id
     */
    private String SkuId;

    /**
     * The sku's name
     */
    private String Name;

    /**
     * The sku's category
     */
    private String Category;

    /**
     * Gets the sku's id
     * @return the sku's id
     */
    public String getSkuId() {
        return SkuId;
    }

    /**
     * Sets the sku's id
     * @param skuId
     * @return the sku
     */
    public SkuDomainModel setSkuId(String skuId) {
        SkuId = skuId;
        return this;
    }

    /**
     * Gets the sku's name
     * @return the sku's name
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the sku's name
     * @param name
     * @return the sku
     */
    public SkuDomainModel setName(String name) {
        Name = name;
        return this;
    }

    /**
     * Gets the sku's category
     * @return the sku
     */
    public String getCategory() {
        return Category;
    }

    /**
     * Sets the sku's category
     * @param category
     * @return the sku
     */
    public SkuDomainModel setCategory(String category) {
        Category = category;
        return this;
    }
}
