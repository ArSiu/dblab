package com.arsiu.model.DAO;

public class PostOfficeDao implements com.arsiu.model.DAO.interfaces.PostOfficeDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("PostOffice");
        }
        return queryGenerator;
    }
}
