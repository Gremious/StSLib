package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.Collection;

public class SuperCopyExampleAction extends AbstractGameSuperCopyAction {
// Takes in a card and a keyword. Returns 3 copies of said card to your hand with the keyword removed.

    private AbstractCard c;
    private Collection<SuperCopyInterface.superCopyKeywords> keywords;

    /**
     * @param c        The card to make 3 copies of with removed keyword
     * @param keywords The keywords to remove.
     */
    public SuperCopyExampleAction(AbstractCard c, Collection<SuperCopyInterface.superCopyKeywords> keywords) {
        // You don't even really need a constructor (although it is recommended for general use).
        // For example, if you wanna have a very specific, reusable action that ONLY does the same thing you can forgo
        // declaring it every time and code it directly e.g. this action will always give you 3 copies of the card
        // since the 3 is hardcoded in addAmount() and it will always remove the keyword.
        this.c = c;
        this.keywords = keywords;
    }

    @Override
    public void addCard() {
        copy.setCard(c);
    }

    @Override
    public void addKeywords() {
        copy.setKeywords(keywords);
    }

    @Override
    public void addRemoveKeyword() {
        copy.setRemoveKeyword(true);
    }

    @Override
    public void addAmount() {
        copy.setAmount(3);
    }

}
