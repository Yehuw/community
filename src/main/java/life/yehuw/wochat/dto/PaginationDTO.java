package life.yehuw.wochat.dto;

import life.yehuw.wochat.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Data
public class PaginationDTO {
    public List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage = true;
    private boolean showNext;
    private boolean showEndPage = true;
    private Integer page;
    private Integer totalPage;
    private Deque<Integer> pages = new LinkedList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page = page;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page.intValue() > totalPage) {
            page = totalPage;
        }
        pages.add(page);

        //show上一页
        showPrevious = (page == 1) ? true : false;
//        if (page == 1) {
//            showPrevious = false;
//        } else
//            showPrevious = true;
        //show下一页
        showNext = ((page == totalPage) ? true : false);
//        if (page == totalPage) {
//            showNext = false;
//        } else
//            showNext = true;
        if (showPrevious) {
            pages.add(page + 1);
            pages.add(page + 2);
        } else if (showNext) {
            pages.addFirst(page - 1);
            pages.addFirst(page - 2);
        } else {
            pages.addFirst(page - 1);
            pages.addLast(page + 1);
        }

        //show第一页
        showFirstPage = (pages.contains(1) ? true : false);
//        if (pages.contains(1)) {
//            showFirstPage = false;
//        } else
//            showFirstPage = true;
        //show最后一页
        showEndPage = ((pages.contains(totalPage)) ? true : false);
//        if (pages.contains(totalPage)) {
//            showEndPage = false;
//        } else
//            showEndPage = true;
    }
}
