package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.Collection;

public interface SuperCopyInterface {

    enum superCopyKeywords {
        INNATE,
        EXHAUST,
        ETHEREAL,
        UNPLAYABLE;
    }

    public void setCard(AbstractCard card);

    public void setKeywords(Collection<superCopyKeywords> keywords);

    public void setRemoveKeyword(boolean removeKeyword);

    public void setCost(Integer setCost);

    public void setAddLocation(CardGroup addLocation);

    public void setRandomSpot(boolean randomSpot);

    public void setAmount(int amount);


}
