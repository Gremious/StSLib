package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import com.evacipated.cardcrawl.mod.stslib.StSLib;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractGameSuperCopyAction extends AbstractGameAction implements SuperCopyBuilderInterface {
    public static final Logger logger = LogManager.getLogger(StSLib.class.getName());
    public SuperCopyGetSet copy;

    public static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("stslib:MakeSuperCopyAction");
    public static final String KEYWORD_STRINGS[] = uiStrings.TEXT;


    public AbstractGameSuperCopyAction() {
        copy = new SuperCopyGetSet();
    }

    @Override
    public void addCard() {
        copy.setCard(new Madness());
    }

    @Override
    public void addKeywords() {
        Collection<SuperCopyInterface.superCopyKeywords> keywords = new ArrayList<>();
        copy.setKeywords(keywords);
    }

    @Override
    public void addRemoveKeyword() {
        copy.setRemoveKeyword(false);
    }

    @Override
    public void addCost() {
        copy.setCost(null);
    }

    @Override
    public void addAddLocation() {
        copy.setAddLocation(AbstractDungeon.player.hand);
    }

    @Override
    public void addRandomSpot() {
        copy.setRandomSpot(false);
    }

    @Override
    public void addAmount() {
        copy.setAmount(1);
    }


    @Override
    public void update() {

        if (duration == Settings.ACTION_DUR_FAST) {
          /*  if (keywords != null) {
                if (keyword.equals(KEYWORD_STRINGS[0])) {
                    if (removeKeyword) {
                        if (c.exhaust) {
                            c.exhaust = false;
                            if (setCost != null) c.cost = setCost;
                            c.rawDescription = c.rawDescription.replaceAll(KEYWORD_STRINGS[1], "");
                            logger.info("Adding " + c + " with REMOVED Exhaust.");
                        }
                    } else {
                        if (!c.exhaust) {
                            c.exhaust = true;
                            if (setCost != null) c.cost = setCost;
                            c.rawDescription = c.rawDescription + KEYWORD_STRINGS[2];
                            logger.info("Adding " + c + " with Exhaust.");
                        }
                    }
                } else if (keyword.equals(KEYWORD_STRINGS[3])) {
                    if (removeKeyword) {
                        if (c.isEthereal) {
                            c.isEthereal = false;
                            if (setCost != null) c.cost = setCost;
                            c.rawDescription = c.rawDescription.replaceAll(KEYWORD_STRINGS[4], "");
                            logger.info("Adding " + c + " with REMOVED Ethereal.");
                        }
                    } else {
                        if (!c.isEthereal) {
                            c.isEthereal = true;
                            if (setCost != null) c.cost = setCost;
                            c.rawDescription = c.rawDescription + KEYWORD_STRINGS[5];
                            logger.info("Adding " + c + " with Ethereal.");
                        }
                    }
                } else if (keyword.equals(KEYWORD_STRINGS[6])) { // makeStatEquivCopy does preserve cost, but not "Unplayable." description.
                    if (removeKeyword) {
                        if (c.cost == -2) {
                            if (setCost != null) {
                                c.cost = setCost;
                            } else {
                                c.cost = 1;
                            }
                            c.rawDescription = c.rawDescription.replaceAll(KEYWORD_STRINGS[7], "");
                            logger.info("Adding " + c + " with REMOVED Unplayable.");
                        }
                    } else {
                        if (c.cost != -2) {
                            c.cost = -2;
                            c.rawDescription = KEYWORD_STRINGS[8] + c.rawDescription;
                            logger.info("Adding " + c + " with Unplayable.");
                        }
                    }

                }
            }
            c.initializeDescription();

            AbstractDungeon.actionManager.addToTop(new SFXAction("CARD_OBTAIN"));

            if (addLocation == AbstractDungeon.player.hand) {
                if (AbstractDungeon.player.hand.size() < BaseMod.MAX_HAND_SIZE) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(c));
                    if (c.hasTag(ThiefCardTags.RARE_FIND))
                        AbstractDungeon.effectList.add(new CardFlashVfx(c, Color.GOLD));
                } else {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(c));
                    if (c.hasTag(ThiefCardTags.RARE_FIND))
                        AbstractDungeon.effectList.add(new CardFlashVfx(c, Color.GOLD));
                }

            } else if (addLocation == AbstractDungeon.player.drawPile) {
                AbstractDungeon.effectList.add(new ShowCardAndAddToDrawPileEffect(c, true, false));
                if (c.hasTag(ThiefCardTags.RARE_FIND)) AbstractDungeon.effectList.add(new CardFlashVfx(c, Color.GOLD));

            } else if (addLocation == AbstractDungeon.player.discardPile) {
                AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(c));
                if (c.hasTag(ThiefCardTags.RARE_FIND)) AbstractDungeon.effectList.add(new CardFlashVfx(c, Color.GOLD));

            } else {
                logger.info("The Super Duper Copy Action didn't find ether hand, deck or discard.");
            }

            AbstractDungeon.player.hand.refreshHandLayout();
            AbstractDungeon.player.hand.glowCheck();
            logger.info("Final log. Super Copy Action should be done.");
            //    tickDuration();
            */
        }
        tickDuration();
    }
}

