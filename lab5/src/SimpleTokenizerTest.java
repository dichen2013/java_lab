import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rui on 8/05/17.
 */
public class SimpleTokenizerTest {
    @Test
    public void hasNext() throws Exception {
        Tokenizer tok = new SimpleTokenizer("()");
        assertTrue("Error 1",tok.hasNext());
        tok = new SimpleTokenizer("");
        assertFalse("Error 2",tok.hasNext());
    }

    @Test
    public void current() throws Exception {
        Tokenizer tok = new SimpleTokenizer("(");
        assertEquals(tok.current(),"(");
        tok = new SimpleTokenizer(")");
        assertEquals(tok.current(),")");
    }

    @Test
    public void next() throws Exception {
        this.hasNext();
        this.current();

        Tokenizer tok = new SimpleTokenizer("()");
        tok.next();
        assert(tok.current().equals(")"));
        tok.next();
        assertFalse(tok.hasNext());
    }
}