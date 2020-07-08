package pojo;

public class SearchData {
    private String searchCriteria;
    private int expectedResults;

    public SearchData(String _searchCriteria, int _expectedNumberOfResults){
        searchCriteria = _searchCriteria;
        expectedResults = _expectedNumberOfResults;
    }

    public void setSearchCriteria(String searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    public void setExpectedResults(int expectedResults){
        this.expectedResults = expectedResults;
    }

    public String getSearchCriteria(){
        return searchCriteria;
    }

    public int getExpectedResults(){
        return expectedResults;
    }
}
