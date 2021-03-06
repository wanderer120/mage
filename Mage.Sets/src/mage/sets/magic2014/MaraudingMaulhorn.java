/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.magic2014;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.decorator.ConditionalRequirementEffect;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.combat.AttacksIfAbleSourceEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.mageobject.NamePredicate;

/**
 *
 * @author jeffwadsworth
 */
public class MaraudingMaulhorn extends CardImpl {
    
    private final static FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent("creature named Advocate of the Beast");    
    static {
        filter.add(new NamePredicate("Advocate of the Beast"));
    }

    public MaraudingMaulhorn(UUID ownerId) {
        super(ownerId, 145, "Marauding Maulhorn", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{2}{R}{R}");
        this.expansionSetCode = "M14";
        this.subtype.add("Beast");

        this.power = new MageInt(5);
        this.toughness = new MageInt(3);

        // Marauding Maulhorn attacks each combat if able unless you control a creature named Advocate of the Beast.
        Effect effect = new ConditionalRequirementEffect(
                new AttacksIfAbleSourceEffect(Duration.WhileOnBattlefield),
                new PermanentsOnTheBattlefieldCondition(filter, PermanentsOnTheBattlefieldCondition.CountType.FEWER_THAN, 1));
        effect.setText("{this} attacks each combat if able unless you control a creature named Advocate of the Beast");

        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, effect));
        
    }

    public MaraudingMaulhorn(final MaraudingMaulhorn card) {
        super(card);
    }

    @Override
    public MaraudingMaulhorn copy() {
        return new MaraudingMaulhorn(this);
    }
}
