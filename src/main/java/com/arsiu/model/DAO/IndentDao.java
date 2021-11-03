package com.arsiu.model.DAO;

public class IndentDao implements com.arsiu.model.DAO.interfaces.IndentDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Indent");
        }
        return queryGenerator;
    }
}
