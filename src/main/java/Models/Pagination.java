package Models;

/**
 *  A pagination object
 */
public class Pagination {
    /**
     * The page size
     */
    public int PageSize;

    /**
     * The current page number
     */
    public int PageNumber;

    /**
     * The total number of items
     */
    public int TotalItems;

    public Pagination(int pageSize, int pageNumber, int totalItems)
    {
        PageSize = pageSize;
        PageNumber = pageNumber;
        TotalItems = totalItems;
    }
}
