package com.example.paymentcardgeneratorserver.Enums;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Defines various payment card types, along with a known list of valid lengths and prefixes, according to
 * <a href="https://en.wikipedia.org/wiki/Payment_card_number">https://en.wikipedia.org/wiki/Payment_card_number</a>
 * as of December, 2016.
 */
public enum CardType {
    AMERICAN_EXPRESS( prefixesFromRange(new Range(34, 34), new Range(37, 37)),
            list(15) ),

    VISA( prefixesFromRange(new Range(4, 4)),
            list(13, 16, 19) ),

    MASTERCARD( prefixesFromRange(new Range(51, 55), new Range(2221, 2720)),
            list(16) ),

    DISCOVER( prefixesFromRange(new Range(65, 65), new Range(644, 649), new Range(6011, 6011), new Range(622126, 622925) ),
            list(16, 19) );


    private Set<Long> prefixes;
    private List<Integer> lengths;


    private CardType( final Set<Long> prefixes, final List<Integer> lengths ) {
        this.prefixes = prefixes;
        this.lengths = lengths;
    }

    public Set<Long> getPrefixes() {
        return prefixes;
    }

    public List<Integer> getLengths() {
        return lengths;
    }

    private static Set<Long> prefixesFromRange( final Range ... ranges ) {
        if( ranges == null || ranges.length == 0 ) throw new IllegalArgumentException( "Ranges is null or empty" );

        final Set<Long> prefixes = new LinkedHashSet<>();

        for( final Range r : ranges ) {
            if( r != null ) {
                final List<Long> list = new ArrayList<>( (int)(r.getEnd() - r.getStart() + 1) );

                for( long i = r.getStart(); i <= r.getEnd(); i++ ) {
                    list.add( i );
                }

                prefixes.addAll( list );
            }
        }

        return Collections.unmodifiableSet( prefixes );
    }

    @SafeVarargs
    private static <T> List<T> list( final T ... stuff ) {
        if( stuff == null || stuff.length == 0 ) throw new IllegalArgumentException( "Null or empty vararg" );

        final List<T> set = new ArrayList<>( stuff.length );

        for( final T t : stuff ) {
            set.add( t );
        }

        return Collections.unmodifiableList( set );
    }
}

