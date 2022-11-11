import org.junit.Before;
import org.junit.Test;

public class SingleLikedListTest {
    SingleLinkedList list;

    @Before
    public void setUpList(){
        list=new SingleLinkedList();
        list.insert(319,"zhiyong");
        list.insert(313,"leihuang");
        list.insert(1102,"brian");

    }

    @Test
    public void addNodeToIndex(){
        list.insert(33,1209,"honghong");
        list.insert(313,1209,"honghong");
        list.showList();
    }

    @Test
    public void deleteTest(){
        //delete exist node
        list.deleteByIndex(319);
        list.showList();
        list.deleteByIndex(1102);
        list.showList();
        //delete no exist node
        list.deleteByIndex(1102);
        //delete last node
        list.deleteByIndex(313);
        list.showList();
        //delete node from empty list
        list.deleteByIndex(313);



    }

    /*
    * given node exist or doesn't exist*/
    @Test
    public void queryTest(){
        String result=list.query(313);
        System.out.println(result);
        result=list.query(3);
        System.out.println(result);
    }

    @Test
    public void updateTest(){
        boolean result=list.update(319,"jian");
        if (result){
            System.out.println("update success");
        }else{
            System.out.println("update fail");
        }

        list.showList();
    }
}
