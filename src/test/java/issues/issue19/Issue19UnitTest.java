package issues.issue19;

import net.sf.cglib.core.Transformer;
<<<<<<< HEAD
import org.ayfaar.app.controllers.SearchController2;
=======
import org.ayfaar.app.controllers.SuggestionsController;
>>>>>>> 32b62b3b57d6f9c0f29e5c1ee9810481c3f7a14b
import org.ayfaar.app.model.Term;
import org.ayfaar.app.utils.AliasesMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static net.sf.cglib.core.CollectionUtils.transform;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class Issue19UnitTest {
    @Mock AliasesMap aliasesMap;

    @InjectMocks
<<<<<<< HEAD
    SearchController2 controller = new SearchController2();
=======
    SuggestionsController controller = new SuggestionsController();
>>>>>>> 32b62b3b57d6f9c0f29e5c1ee9810481c3f7a14b

    @Test
    public void testSequence() {
        String q = "a";
        List<String> fakeTerms = asList("a", "1 a", "bterfd", "b-aaaa", "aa", "242a424");

        Mockito.when(aliasesMap.getAllTerms()).thenReturn(transform(fakeTerms, new Transformer() {
            @Override
            public Object transform(Object value) {
                return new Term((String) value);
            }
        }));

        List<String> suggestions = controller.suggestions(q);

        assertEquals(5, suggestions.size());
        assertEquals("a", suggestions.get(0));
        assertEquals("aa", suggestions.get(1));
        assertEquals("1 a", suggestions.get(2));
        assertEquals("b-aaaa", suggestions.get(3));
        assertEquals("242a424", suggestions.get(4));
    }


    @Test
    public void testMaxSize() {
        String q = "гал";
        List<String> fakeTerms = asList("Галактическая Сущность", "Галактическая Странник", "Галактический УЛУУГУМА-Дезинтеграционный Луч АИЙ-ЙЯ",
                                        "Звёздно-Галактическая Форма", "Вселенский Межгалактический Диапазон", "Межгалактический",
                                        "Межгалактические Комплекс-Планы", "Межгалактический Астральный Комплекс-План", "Галактика");

        Mockito.when(aliasesMap.getAllTerms()).thenReturn(transform(fakeTerms, new Transformer() {
            @Override
            public Object transform(Object value) {
                return new Term((String) value);
            }
        }));

        List<String> suggestions = controller.suggestions(q);
<<<<<<< HEAD
        assertTrue(suggestions.size() <= SearchController2.MAX_SUGGESTIONS);
=======
        assertTrue(suggestions.size() <= SuggestionsController.MAX_SUGGESTIONS);
>>>>>>> 32b62b3b57d6f9c0f29e5c1ee9810481c3f7a14b
    }
}
