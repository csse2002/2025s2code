package v2.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleSet {
    private List<ProgramRules> rules;

    public RuleSet() {
        this.rules = new ArrayList<>();
    }

    public RuleSet addRule(ProgramRules rule) {
        RuleSet collection = new RuleSet();
        collection.rules = new ArrayList<>(rules);
        collection.rules.add(rule);
        return collection;
    }

    public ProgramRules build() {
        return new CompositeRule(rules);
    }
}
