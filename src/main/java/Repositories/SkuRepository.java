package Repositories;

import Models.PagedResult;
import Models.SkuDomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A sku repository
 */
public class SkuRepository {
    Random random;
    List<SkuDomainModel> skus;

    public SkuRepository() {
        random = new Random();
        skus = new ArrayList<>();
        GenerateMockSkus();
    }

    /**
     * Gets the first page of sku's, using the default page size
     *
     * @return a paged result of skus
     */
    public PagedResult<SkuDomainModel> GetSkus() {
        return GetSkus(20, 1);
    }

    /**
     * Gets a page of skus
     *
     * @param pageSize   The page size
     * @param pageNumber The page number
     * @return a pages result of skus
     */
    public PagedResult<SkuDomainModel> GetSkus(int pageSize, int pageNumber) {
        if (pageSize <= 0) {
            pageSize = 20;
        }

        if (pageNumber < 1) {
            pageNumber = 1;
        }

        var startingIndex = (pageNumber - 1) * pageSize;
        var skuPage = new ArrayList<SkuDomainModel>();
        for (int i = startingIndex; i < startingIndex + pageSize; i++) {
            skuPage.add(skus.get(i));
        }

        return new PagedResult<>(skuPage, pageSize, pageNumber, skus.size());
    }

    /**
     * Generate a mock collection of skus
     */
    private void GenerateMockSkus() {
        for (int i = 1; i <= 500; i++) {
            var sku = new SkuDomainModel()
                    .setSkuId(padLeftZeros(Integer.toString(i), 5))
                    .setName(String.format("Sku %d", i))
                    .setCategory(GetRandomCategory());

            skus.add(sku);
        }
    }

    /**
     * Pads a string to a fixed length with leading 0s
     * @param inputString The string to pad left
     * @param length The desired string length
     * @return the padded string
     */
    private String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        var sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    /**
     * Gets a random category
     * @return a category string
     */
    private String GetRandomCategory() {
        switch (random.nextInt(0, 4)) {
            case 0:
                return "Tool";
            case 1:
                return "Consumable";
            default:
                return "Other";
        }
    }
}
