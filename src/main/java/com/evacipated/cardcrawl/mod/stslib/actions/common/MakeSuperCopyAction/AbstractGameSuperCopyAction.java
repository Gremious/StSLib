package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import basemod.BaseMod;
import com.evacipated.cardcrawl.mod.stslib.StSLib;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDiscardEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractGameSuperCopyAction extends AbstractGameAction implements SuperCopyBuilderInterface {
    public static final Logger logger = LogManager.getLogger(StSLib.class.getName());

    public SuperCopyGetSet copy;
    public AbstractCard card = new Madness();
    private ArrayList<AbstractCard> amountCards = new ArrayList<>();
    public static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("stslib:MakeSuperCopyAction");
    public static final String KEYWORD_STRINGS[] = uiStrings.TEXT;


    public AbstractGameSuperCopyAction() {
        copy = new SuperCopyGetSet();
        this.duration = Settings.ACTION_DUR_FASTER;

        addCard();
        addKeywords();
        addRemoveKeyword();
        addCost();
        addAddLocation();
        addRandomSpot();
        addAddToBottomOfDeck();
        addAmount();

        for (int i = 0; i < copy.getAmount(); i++) {
            amountCards.add(copy.getCard().makeStatEquivalentCopy());
        }

    }

    // Set your setters. Ready your getters. Vroom vroom.

    @Override
    public void addCard() {
        copy.setCard(card);
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
    public void addAddToBottomOfDeck() {
        copy.setAddToBottomOfDeck(false);
    }

    @Override
    public void addAmount() {
        copy.setAmount(1);
    }

    //--
    // Keywords:

    public void setupKeywords() {
        setupExhaust();
        setupEthereal();
    }

    public void setupExhaust() {
        if (copy.getKeywords() != null && copy.getKeywords().contains(SuperCopyInterface.superCopyKeywords.EXHAUST)) {
            for (AbstractCard c : amountCards) {
                if (copy.getRemoveKeyword()) {
                    if (c.exhaust) {
                        c.exhaust = false;
                        c.rawDescription = c.rawDescription.replaceAll(KEYWORD_STRINGS[2], "");
                        logger.info("Adding a copy of " + c + " with REMOVED Exhaust.");
                    }
                } else {
                    if (!c.exhaust) {
                        c.exhaust = true;
                        c.rawDescription = c.rawDescription + KEYWORD_STRINGS[3];
                        logger.info("Adding a copy of " + c + " with Exhaust.");
                    }
                }
            }
        }
    }

    public void setupEthereal() {
        if (copy.getKeywords() != null && copy.getKeywords().contains(SuperCopyInterface.superCopyKeywords.ETHEREAL)) {
            for (AbstractCard c : amountCards) {
                if (copy.getRemoveKeyword()) {
                    if (c.exhaust) {
                        c.exhaust = false;
                        c.rawDescription = c.rawDescription.replaceAll(KEYWORD_STRINGS[4], "");
                        logger.info("Adding a copy of " + c + " with REMOVED Exhaust.");
                    }
                } else {
                    if (!c.exhaust) {
                        c.exhaust = true;
                        c.rawDescription = c.rawDescription + KEYWORD_STRINGS[5];
                        logger.info("Adding a copy of " + c + " with Exhaust.");
                    }
                }
            }
        }
    }

    //--
    // Cost:

    public void setupCost() {
        if (copy.getCost() != null) {
            if (copy.getKeywords() != null && copy.getKeywords().contains(SuperCopyInterface.superCopyKeywords.UNPLAYABLE)) {
                for (AbstractCard c : amountCards) {
                    c.cost = -2;
                }
            } else {
                card.cost = copy.getCost();
            }
        }
    }

    //--
    // Add the cards to location:

    public void setupAddLocation() {
        for (AbstractCard c : amountCards) {
            AbstractDungeon.actionManager.addToTop(new SFXAction("CARD_OBTAIN"));

            if (copy.getAddLocation() == AbstractDungeon.player.hand) {
                if (AbstractDungeon.player.hand.size() < BaseMod.MAX_HAND_SIZE) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(c));
                } else {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(c));
                }

            } else if (copy.getAddLocation() == AbstractDungeon.player.drawPile) {
                AbstractDungeon.effectList.add(new ShowCardAndAddToDrawPileEffect(c, copy.getRandomSpot(), copy.getAddToBottomOfDeck()));

            } else if (copy.getAddLocation() == AbstractDungeon.player.discardPile) {
                AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(c));

            } else {
                logger.info("The Super Copy Action didn't find ether hand, deck or discard.");
            }

            AbstractDungeon.player.hand.refreshHandLayout();
            AbstractDungeon.player.hand.glowCheck();
            logger.info("Final log. Super Copy Action should be done.");
        }

    }

    //--

    @Override
    public void update() {
        if (duration == Settings.ACTION_DUR_FASTER) {

            setupKeywords();
            setupCost();
            setupAddLocation();
            tickDuration();
        }
    }
}

 /*
           if (keywords != null) {
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

            //    tickDuration();
            */


