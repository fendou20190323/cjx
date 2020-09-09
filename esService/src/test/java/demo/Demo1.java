package demo;


import com.fendou.ESApplication;
import com.fendou.modle.TestBean;
import com.fendou.service.TestService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-09-09 13:58
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class Demo1 {

    @Autowired
    TestService testService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void fun1(){
        elasticsearchTemplate.createIndex(TestBean.class);
        elasticsearchTemplate.putMapping(TestBean.class);
    }

    @Test
    public void init(){
        testService.save(new ArrayList<TestBean>());
    }

    @Test
    public void test2(){
        Iterable<TestBean> all = testService.findAll();
        for (TestBean testBean : all) {
            System.err.println(testBean);
        }
    }

    @Test
    public void test3(){
        List<TestBean> re = testService.findByName("欢彦");
        System.err.println(re);
    }
    @Test
    public void test4(){
        /** 查询某个字段中模糊包含目标字符串，使用matchQuery
         * */
//        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("desc", "我个子很高")).build();

        /**和match查询类似，match_phrase查询首先解析查询字符串来产生一个词条列表。
         * 然后会搜索所有的词条，但只保留包含了所有搜索词条的文档，并且词条的位置要邻接。
         * 一个针对短语“中华共和国”的查询不会匹配“中华人民共和国”，因为没有含有邻接在一起的“中华”和“共和国”词条。
         这种完全匹配比较严格，类似于数据库里的“%落日熔金%”这种，使用场景比较狭窄。
         如果我们希望能不那么严格，譬如搜索“中华共和国”，希望带“我爱中华人民共和国”的也能出来，就是分词后，中间能间隔几个位置的也能查出来，可以使用slop参数。
         * */
//        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchPhraseQuery("desc", "我个子很高")).build();

        /**我们可以用这个来做那种需要==查询的操作，当传userId=1时，会查询出来所有userId为1的集合。
         通常情况下，我们不会使用term查询，绝大部分情况我们使用ES的目的就是为了使用它的分词模糊查询功能。
         而term一般适用于做过滤器filter的情况，譬如我们去查询title中包含“浣溪沙”且userId=1时，
         那么就可以用termQuery(“userId”, 1)作为查询的filter。
         * */
//        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("id", 1l)).build();

        /**如果我们希望title，content两个字段去匹配某个字符串，只要任何一个字段包括该字符串即可，就可以使用multimatch。
         * */
//        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(0L, "age","sex")).build();



        /**之前的查询中，当我们输入“我天”时，ES会把分词后所有包含“我”和“天”的都查询出来，
         * 如果我们希望必须是包含了两个字的才能被查询出来，那么我们就需要设置一下Operator。
         * */
//        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("desc", "我个").operator(Operator.AND)).build();


        List<Long> ids=new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        /**合并查询
         即boolQuery，可以设置多个条件的查询方式。它的作用是用来组合多个Query，有四种方式来组合，must，mustnot，filter，should。
         must代表返回的文档必须满足must子句的条件，会参与计算分值；
         filter代表返回的文档必须满足filter子句的条件，但不会参与计算分值；
         should代表返回的文档可能满足should子句的条件，也可能不满足，有多个should时满足任何一个就可以，通过minimum_should_match设置至少满足几个。
         mustnot代表必须不满足子句的条件。

         SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().must(termQuery("userId", userId))
         .should(rangeQuery("weight").lt(weight)).must(matchQuery("title", title))).build();
         * */
        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("id", ids))).build();
        List<TestBean> testBeans = elasticsearchTemplate.queryForList(searchQuery, TestBean.class);
        for (TestBean testBean : testBeans) {
            System.err.println(testBean);
        }
        /**如果某个字段需要匹配多个值，譬如userId为1，2，3任何一个的，类似于mysql中的in，那么可以使用termsQuery(“userId”, ids).
         如果某字段是字符串，我建议空的就设置为null，不要为""空串，貌似某些版本的ES，使用matchQuery空串会不生效。
         详细点的看这篇http://blog.csdn.net/dm_vincent/article/details/41743955
         * */
    }

    @Test
    public void test5(){
        testService.delete("1l");
    }
}
