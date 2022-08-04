package com.example.paymentcardgeneratorserver.Interfaces;
import com.example.paymentcardgeneratorserver.Enums.CardType;
import com.example.paymentcardgeneratorserver.Types.Card;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface PaymentCardGenerator {

    /**
     * Generates a card number for a given card type.  The prefix and length are
     * randomly selected from the values defined in {@linkplain CardType}.
     *
     * @param cardType The type of card number of generate
     *
     * @return A card number for the specified card type
     */
    public String generateByCardType( CardType cardType );

    /**
     * Generates multiple card numbers for a given card type.  The prefix and length
     * are randomly selected from the values defined in {@linkplain CardType}.
     *
     * @param howMany How many card numbers to generate for the specified card type
     * @param cardType The type of card numbers to generate
     *
     * @return A list of card numbers for the specified card type
     */
    public List<Card> generateListByCardType(int howMany, CardType cardType ) throws Exception;

    /**
     * Generates card numbers of given card types.  The prefix and length are
     * randomly selected from the values defined in {@linkplain CardType}.
     *
     * @param howManyOfEach How many card numbers to generate for each card type
     * @param cardTypes Vararg of card types
     *
     * @return A map where the key is the card type and the value is a list of card numbers for that card type
     */
    public Map<CardType, List<String>> generateMapByCardTypes( int howManyOfEach, CardType ... cardTypes );

    /**
     * Generates numbers based on a specified prefix and length.  This method does not validate the prefix
     * or length arguments to determine whether they apply to a known {@linkplain CardType}.  This is to
     * account for the possibility that the Wikipedia articles this software is based on are incorrect, or
     * that this software could be outdated.  Known prefix and length options are available in the
     * {@linkplain CardType} enum, if you wish to use them.  Essentially, this method is a general-purpose
     * Luhn number generator.
     *
     * @param howManyOfEachPrefix How many card numbers to generate for each prefix
     * @param lengths Generated card numbers will be of lengths specified by this list
     * @param prefixes Generated card numbers will start with values from this set
     *
     * @return A map where the key is the prefix and the value is a list of card numbers for that prefix
     */
    public Map<Long, List<String>> generateByPrefix( int howManyOfEachPrefix, List<Integer> lengths, Set<Long> prefixes );

    /**
     * Determines whether a number passes Luhn validation
     *
     * @param num A numeric string ending with a check digit
     *
     * @return {@code true} if the number is valid, {@code false} if not
     */
    public boolean passesLuhnCheck( String num );
}
