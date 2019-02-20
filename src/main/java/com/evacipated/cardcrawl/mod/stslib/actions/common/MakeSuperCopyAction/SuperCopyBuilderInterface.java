package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

public interface SuperCopyBuilderInterface {

    public void addCard();

    public void addKeywords();

    public void addRemoveKeyword();

    public void addCost();

    public void addAddLocation();

    public void addRandomSpot();

    public void addAddToBottomOfDeck();

    public void addAmount();
}
