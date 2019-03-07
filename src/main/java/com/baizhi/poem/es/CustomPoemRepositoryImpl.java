/**
 * @Title: CustomPoemRepositoryImpl
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/619:43
 */

package com.baizhi.poem.es;

import com.baizhi.poem.entity.PoemDTO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class CustomPoemRepositoryImpl implements CustomPoemRepository {

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public List<PoemDTO> findByNameLikeAndHighLightAndPageAble(Integer start, Integer page, String name) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("name", name))
                .withHighlightFields(new HighlightBuilder.Field("name"))
                .withPageable(new PageRequest((start - 1) * page, page))
                .withSort(SortBuilders.fieldSort("_id").order(SortOrder.ASC))
                .build();
        AggregatedPage<PoemDTO> poemDTOS = template.queryForPage(query, PoemDTO.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                ArrayList<PoemDTO> poemDTOS = new ArrayList<>();
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    if (hits.getHits().length <= 0) {
                        return null;
                    }
                    PoemDTO poemDTO = new PoemDTO();
                    poemDTO.setId(hit.getId());
                    poemDTO.setContent(hit.getSourceAsMap().get("content").toString());
                    poemDTO.setCreated(new Date(Long.parseLong(hit.getSourceAsMap().get("created").toString())));
                    poemDTO.setUpdate(new Date(Long.parseLong(hit.getSourceAsMap().get("update").toString())));
                    poemDTO.setTitle(hit.getSourceAsMap().get("title").toString());
                    String name = hit.getHighlightFields().get("name").fragments()[0].toString();
                    poemDTO.setName(name);
                    poemDTOS.add(poemDTO);
                }
                return new AggregatedPageImpl<T>((List<T>) poemDTOS);
            }
        });
        return poemDTOS.getContent();
    }
    @Override
    public List<PoemDTO> findByTitleLikeAndHighLightAndPageAble(Integer start, Integer page, String title) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("title", title))
                .withHighlightFields(new HighlightBuilder.Field("title"))
                .withPageable(new PageRequest((start - 1) * page, page))
//                .withSort(SortBuilders.fieldSort(name).order(SortOrder.ASC))
                .build();
        AggregatedPage<PoemDTO> poemDTOS = template.queryForPage(query, PoemDTO.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                ArrayList<PoemDTO> poemDTOS = new ArrayList<>();
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    if (hits.getHits().length <= 0) {
                        return null;
                    }
                    PoemDTO poemDTO = new PoemDTO();
                    poemDTO.setId(hit.getId());
                    poemDTO.setContent(hit.getSourceAsMap().get("content").toString());
                    poemDTO.setCreated(new Date(Long.parseLong(hit.getSourceAsMap().get("created").toString())));
                    poemDTO.setUpdate(new Date(Long.parseLong(hit.getSourceAsMap().get("update").toString())));
                    poemDTO.setName(hit.getSourceAsMap().get("name").toString());
                    String name =
                            hit.getHighlightFields().get("title").fragments()[0].toString();
                    poemDTO.setTitle(name);
                    poemDTOS.add(poemDTO);
                }
                return new AggregatedPageImpl<T>((List<T>) poemDTOS);
            }
        });
        return poemDTOS.getContent();
    }

    @Override
    public List<PoemDTO> findByContentLikeAndHighLightAndPageAble(Integer start, Integer page, String content) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("content", content))
                .withHighlightFields(new HighlightBuilder.Field("content"))
                .withPageable(new PageRequest((start - 1) * page, page))
//                .withSort(SortBuilders.fieldSort(name).order(SortOrder.ASC))
                .build();
        AggregatedPage<PoemDTO> poemDTOS = template.queryForPage(query, PoemDTO.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                ArrayList<PoemDTO> poemDTOS = new ArrayList<>();
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    if (hits.getHits().length <= 0) {
                        return null;
                    }
                    PoemDTO poemDTO = new PoemDTO();
                    poemDTO.setId(hit.getId());
                    poemDTO.setName(hit.getSourceAsMap().get("name").toString());
                    poemDTO.setCreated(new Date(Long.parseLong(hit.getSourceAsMap().get("created").toString())));
                    poemDTO.setUpdate(new Date(Long.parseLong(hit.getSourceAsMap().get("update").toString())));
                    poemDTO.setTitle(hit.getSourceAsMap().get("title").toString());
                    String name =
                            hit.getHighlightFields().get("content").fragments()[0].toString();
                    poemDTO.setContent(name);
                    poemDTOS.add(poemDTO);
                }
                return new AggregatedPageImpl<T>((List<T>) poemDTOS);
            }
        });
        return poemDTOS.getContent();
    }
}
