package Models;

import java.util.List;

/**
 * A result of models with pagination
 * @param <TDomainModel> The model type
 */
public class PagedResult<TDomainModel> {

    /**
     * The domain models
     */
    public List<TDomainModel> DomainModels;

    /**
     * The pagination
     */
    public Pagination Pagination;

    public PagedResult(List<TDomainModel> domainModels, int pageSize, int pageNumber, int totalItems)
    {
        DomainModels = domainModels;
        Pagination = new Pagination(pageSize, pageNumber, totalItems);
    }
}