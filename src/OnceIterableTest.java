import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class OnceIterableTest {

    @Test
    public void test() {
        class OnceIterableArrayList extends ArrayList<String>
        {
            /**
             * 
             */
            private static final long serialVersionUID = -5961789443447623011L;
            private Iterator<String> iterator_ = null;

            @Override
            public Iterator<String> iterator() {
                if (iterator_ == null)
                    iterator_ = super.iterator();
                return iterator_;
            }            
        }
        OnceIterableArrayList list = new OnceIterableArrayList();
        list.add("Hi");
        list.add("Bye");
        for (int i = 0; i < 2; i++)
        {
            // The second time nothing will be output
            // because the iterator has been exhausted
            for (String word : list)
            {
                System.err.println(word);
            }
        }
        fail("Not yet implemented");
    }

}
