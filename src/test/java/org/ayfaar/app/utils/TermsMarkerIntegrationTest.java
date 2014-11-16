package org.ayfaar.app.utils;

import org.ayfaar.app.IntegrationTest;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class TermsMarkerIntegrationTest extends IntegrationTest {
    @Inject
    TermsMarker termsMarker;

    @Test
    public void test() {

        final String text = "Например, Формо-Творцы АДД-МАДД-ФЛУЙФ-Уровня, организующие высшие ГЛЭИИЙО-реальности";
        //final String expected = "Например, <term id=\"Формо-Творец\">Формо-Творцы</term> " +
        //        "АДД-МАДД-ФЛУЙФ-Уровня, организующие высшие <term id=\"ГЛЭИИЙО\">ГЛЭИИЙО</term>-реальности";
        final String expected = "Например, <term id=\"Формо-Творец\">Формо-Творцы</term> АДД-МАДД-ФЛУЙФ-Уровня, " +
                "организующие высшие <term id=\"ГЛЭИИЙО\">ГЛЭИИЙО</term>-<term id=\"реальность\">реальности</term>";
        final String actual = termsMarker.mark(text);
        assertEquals(expected, actual);

        final String text2 = "Всё Самосознание ССС-Сущности действительности. Всё Пространство в каждой из своих бесчисленных «резонационных зон» структурировано множеством разнокачественных стоячих волн, которые, как бы накладываясь друг на друга и тем самым либо подавляясь, либо модулируясь, образуют в каждом из частотных Уровней возможного Восприятия абсолютно всю качественную динамику видимой и субъективно переживаемой нами «картинки» окружающей нас в каждый момент действительности.";
        final String expected2 = "Всё <term id=\"Самосознание ССС-Сущности\">Самосознание ССС-Сущности</term> действительности. Всё <term id=\"Пространство\">Пространство</term> в каждой из своих бесчисленных «<term id=\"Резонационная зона\">резонационных зон</term>» структурировано множеством разнокачественных стоячих волн, которые, как бы накладываясь друг на друга и тем самым либо подавляясь, либо модулируясь, образуют в каждом из частотных Уровней возможного Восприятия абсолютно всю качественную динамику видимой и субъективно переживаемой нами «картинки» окружающей нас в каждый момент действительности.";
        final String actual2 = termsMarker.mark(text2);
        assertEquals(expected2, actual2);

        final String text3 = "Всё Самосознание ССС-Сущности действительности.";
        final String expected3 = "Всё <term id=\"Самосознание ССС-Сущности\">Самосознание ССС-Сущности</term> действительности.";
        final String actual3 = termsMarker.mark(text3);
        assertEquals(expected3, actual3);

        final String text4 = "Последние отражают собой наличие в Энерго-Плазме того общего Энерго-Потенциала, который необходимо реализовать через Фокусные Динамики Форм Самосознаний абсолютно всех Уровней Энерго-Плазмы для того, чтобы нивелировать образовавшееся в разнокачественных сочетаниях диссонационное состояние и привести общую сллоогрентную фокусную Конфигурацию Мироздания в резонационное, взаимоуравновешивающее состояние. В результате одновременной активности двух Импульс-Потенциалов «внутри» Информации образовались условия для проявления Ею некоего Творческого Потенциала. Это обстоятельство мы обозначили как Энергия нарушенных (изменённых благодаря ИИП и ЭИП) взаимосвязей как между, так и внутри реконверстных Конфигураций, которые следует тут же откорректировать. То есть «внутри» Информации появилась возможность для возникновения особого Универсального Состояния - Энерго-Плазмы, которое ассоциируется с некой неуравновешенностью чего-то одного по отношению к чему-то другому. Энергия здесь отражает диссонационное состояние какой-то части скунккций информационных фрагментов (участки реконверстных Конфигураций, которые не смогли совместиться), в то время как Плазма (ССС) представляет Собой ту часть Информации, которая всегда пребывает в резонационном состоянии. В целом всё это образует собой то активное сллоогрентное Состояние Информации, которое мы интерпретируем как Энерго-Плазма.";
        final String expected4 = "Последние отражают собой наличие в <term id=\"Энерго-Плазма\">Энерго-Плазме</term> того общего <term id=\"Энерго-Потенциал\">Энерго-Потенциала</term>, который необходимо реализовать через <term id=\"Фокусная Динамика\">Фокусные Динамики</term> <term id=\"Форма\">Форм</term> <term id=\"Самосознание\">Самосознаний</term> абсолютно всех Уровней <term id=\"Энерго-Плазма\">Энерго-Плазмы</term> для того, чтобы нивелировать образовавшееся в разнокачественных сочетаниях диссонационное состояние и привести общую сллоогрентную <term id=\"Фокусная Конфигурация\">фокусную Конфигурацию</term> <term id=\"Мироздание\">Мироздания</term> в резонационное, взаимоуравновешивающее состояние. В результате одновременной активности двух Импульс-Потенциалов «внутри» Информации образовались условия для проявления Ею некоего Творческого Потенциала. Это обстоятельство мы обозначили как <term id=\"Энергия\">Энергия</term> нарушенных (изменённых благодаря <term id=\"ИИП\">ИИП</term> и <term id=\"ЭИП\">ЭИП</term>) взаимосвязей как между, так и внутри <term id=\"реконверстная Конфигурация\">реконверстных Конфигураций</term>, которые следует тут же откорректировать. То есть «внутри» Информации появилась возможность для возникновения особого Универсального Состояния - <term id=\"Энерго-Плазма\">Энерго-Плазмы</term>, которое ассоциируется с некой неуравновешенностью чего-то одного по отношению к чему-то другому. <term id=\"Энергия\">Энергия</term> здесь отражает диссонационное состояние какой-то части скунккций информационных фрагментов (участки <term id=\"реконверстная Конфигурация\">реконверстных Конфигураций</term>, которые не смогли совместиться), в то <term id=\"Время\">время</term> как Плазма (<term id=\"ССС\">ССС</term>) представляет Собой ту часть Информации, которая всегда пребывает в резонационном состоянии. В целом всё это образует собой то активное сллоогрентное Состояние Информации, которое мы интерпретируем как <term id=\"Энерго-Плазма\">Энерго-Плазма</term>.";
        final String actual4 = termsMarker.mark(text4);
        assertEquals(expected4, actual4);

        //2.0372
        final String text5 = "Каждый очередной момент Синтеза тех или иных Аспектов Качеств в ф-Конфигурации Формы Самосознания характеризуется лишь определённым увеличением концентрации содержащейся в ней разно-Качественной Информации – за счёт повышения степени коварллертности образующих Её взаимосвязей. А повышение концентрации - это вовсе не «абсолютное сплавление» Аспектов друг с другом (насколько бы они ни были идентичны – лийллусцивны - по Смыслу свойственной каждому из Них Информации), а Их способность к постоянно увеличивающемуся сосредоточению (собиранию, скапливанию, агрегации) в какой-то единице объёма Информации, которую в Пространстве-Времени и выражает та или иная Форма проявления Самосознания.";
        final String expected5 = "Каждый очередной момент <term id=\"Синтез\">Синтеза</term> тех или иных <term id=\"Аспект\">Аспектов</term> Качеств в <term id=\"ф-Конфигурация\">ф-Конфигурации</term> <term id=\"Форма Самосознания\">Формы Самосознания</term> характеризуется лишь определённым увеличением концентрации содержащейся в ней разно-Качественной Информации - за счёт повышения степени <term id=\"Коварллертность\">коварллертности</term> образующих Её взаимосвязей. А повышение концентрации - это вовсе не «абсолютное сплавление» <term id=\"Аспект\">Аспектов</term> друг с другом (насколько бы они ни были идентичны - лийллусцивны - по Смыслу свойственной каждому из Них Информации), а Их способность к постоянно увеличивающемуся сосредоточению (собиранию, скапливанию, агрегации) в какой-то единице объёма Информации, которую в <term id=\"Пространство-Время\">Пространстве-Времени</term> и выражает та или иная <term id=\"Форма\">Форма</term> проявления <term id=\"Самосознание\">Самосознания</term>.";
        final String actual5 = termsMarker.mark(text5);
        assertEquals(expected5, actual5);

        final String text6 = " Качеств ВСЕ-Любовь–ВСЕ-Мудрость и ВСЕ-Воля–ВСЕ-Разума в ";
        final String expected6 = " Качеств <term id=\"ВСЕ-Любовь-ВСЕ-Мудрость\">ВСЕ-Любовь-ВСЕ-Мудрость</term> и <term id=\"ВСЕ-Воля-ВСЕ-Разума\">ВСЕ-Воля-ВСЕ-Разума</term> в ";
        final String actual6 = termsMarker.mark(text6);
        assertEquals(expected6, actual6);


        //2.0382
        final String text7 = "Вся эта симультанно, Вся эта -симультанно,";
        final String expected7 = "Вся эта <term id=\"Симультанно\" has-short-description=\"true\">симультанно</term>, Вся эта -<term id=\"Симультанно\" has-short-description=\"true\">симультанно</term>,";
        final String actual7 = termsMarker.mark(text7);
        assertEquals(expected7, actual7);

        final String text8 = "организующие ГЛЭИИЙО-мерность) имеют";
        final String expected8 = "организующие <term id=\"ГЛЭИИЙО-мерность\">ГЛЭИИЙО-мерность</term>) имеют";
        final String actual8 = termsMarker.mark(text8);
        assertEquals(expected8, actual8);

    }
}
