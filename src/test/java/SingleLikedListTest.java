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
        list.deleteByIndex(313);
        list.showList();

        list.deleteByIndex(3);
        list.showList();
    }

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
