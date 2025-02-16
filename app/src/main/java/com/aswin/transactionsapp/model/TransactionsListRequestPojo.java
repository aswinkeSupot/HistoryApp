package com.aswin.transactionsapp.model;

import com.google.gson.annotations.SerializedName;

public class TransactionsListRequestPojo {
    @SerializedName("CountryId")
    private String countryId;
    @SerializedName("SearchTerm")
    private String searchTerm;
    @SerializedName("Paging")
    private PagingBean paging;

    public String getCountryId() {
        return countryId;
    }
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getSearchTerm() {
        return searchTerm;
    }
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public PagingBean getPaging() {
        return paging;
    }
    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public static class PagingBean {
        @SerializedName("Page")
        private Integer page;
        @SerializedName("PerPage")
        private Integer perPage;

        public Integer getPage() {
            return page;
        }
        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }
        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }
    }
}
