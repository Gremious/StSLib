package com.evacipated.cardcrawl.mod.stslib.actions.common.MakeSuperCopyAction;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.colorless.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.Collection;

public class SuperCopyTestCard extends CustomCard {


    // TEXT DECLARATION

    public static final String ID = "SuperCopyTestCard";

    public static final String IMG = "images/stslib/powers/32/stun.png";

    public static final String NAME = "Test";
    public static final String DESCRIPTION = "Copy a card !M! times.";
    public static final String UPGRADE_DESCRIPTION = "Copy a card !M! times.";

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.COLORLESS;

    private static final int COST = 0;

    private static final int MAGIC = 3;

    // /STAT DECLARATION/


    public SuperCopyTestCard() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
        this.magicNumber = this.baseMagicNumber = MAGIC;

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Collection<SuperCopyInterface.superCopyKeywords> keywords = new ArrayList<>();
        keywords.add(SuperCopyInterface.superCopyKeywords.EXHAUST);

        AbstractDungeon.actionManager.addToTop(new SuperCopyExampleAction(new Shiv(), keywords));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
}