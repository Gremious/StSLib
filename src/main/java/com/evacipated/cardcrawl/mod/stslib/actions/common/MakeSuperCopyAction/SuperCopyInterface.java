package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.Collection;

public interface SuperCopyInterface {

    public AbstractCard setCard(AbstractCard card);
    public AbstractCard setkeywords(Collection<MakeSuperCopyAction.superCopyKeywords> keywords);

    /**
     * Will not change the card if it already has/doesn't have the keyword, respectively of what you're using the action for.
     *
     * @param c             the card that needs to be Copied.
     * @param keyword       use KeywordEnums
     * @param setCost       Will change the card cost.
     * @param removeKeyword Will remove the keyword instead of adding it.
     * @param randomSpot    If adding to deck or discard, should it add to a random spot or to the top?
     * @param amount        How many copies this action will add.
     * @param addLocation   Hand, Draw and Discard pile groups from AbstractDungeon.player
     */


}
