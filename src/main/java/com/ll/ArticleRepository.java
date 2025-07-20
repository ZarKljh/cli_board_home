package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {

    public int create(String inputTitle, String inputContent, String memberUserId){

        String sql = String.format("insert into article set title='%s', content='%s', userId='%s', regDate = now()", inputTitle, inputContent, memberUserId);
        int id = Container.getDBConnection().insert(sql);

        return id;
    }
    public List<Article> findAll(){

        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from article");

        for(Map<String, Object> row : rows){
            Article article = new Article(row);
            articleList.add(article);
        }
        return articleList;
    }

    public void modify(Article article, String inputTitle, String inputContent){
        String sql = String.format("update article set title='%s', content='%s' where id='%d'", inputTitle, inputContent, article.getId());
        Container.getDBConnection().update(sql);
    }
    public void remove(Article article){
        String sql = String.format("Delete from article where id ='%d'", article.getId());
        Container.getDBConnection().delete(sql);
    }
}
