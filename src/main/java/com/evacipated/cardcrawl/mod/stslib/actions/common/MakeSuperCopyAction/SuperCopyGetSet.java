package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.Collection;

public class SuperCopyGetSet implements SuperCopyInterface {

    private AbstractCard card;
    private int amount;
    private CardGroup addLocation;
    private Collection<superCopyKeywords> keywords;
    private Integer setCost;
    private boolean removeKeyword;
    private boolean randomSpot;
    private boolean toBottom;


    @Override
    public void setCard(AbstractCard card) {
        this.card = card.makeStatEquivalentCopy();
    }

    public AbstractCard getCard() {
        return card;
    }

    @Override
    public void setKeywords(Collection<superCopyKeywords> keywords) {
        this.keywords = keywords;
    }

    public Collection<superCopyKeywords> getKeywords() {
        return keywords;
    }

    @Override
    public void setCost(Integer setCost) {
        this.setCost = setCost;
    }

    public Integer getCost() {
        return setCost;
    }

    @Override
    public void setRemoveKeyword(boolean removeKeyword) {
        this.removeKeyword = removeKeyword;
    }

    public boolean getRemoveKeyword() {
        return removeKeyword;
    }

    @Override
    public void setRandomSpot(boolean randomSpot) {
        this.randomSpot = randomSpot;
    }

    public boolean getRandomSpot() {
        return randomSpot;
    }

    @Override
    public void setAddToBottomOfDeck(boolean toBottom) {
        this.toBottom = toBottom;
    }

    public boolean getAddToBottomOfDeck() {
        return toBottom;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public void setAddLocation(CardGroup addLocation) {
        this.addLocation = addLocation;
    }

    public CardGroup getAddLocation() {
        return addLocation;
    }

}
