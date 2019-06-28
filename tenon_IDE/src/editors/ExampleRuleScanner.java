package editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordPatternRule;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ExampleRuleScanner extends RuleBasedScanner {
  private static Color COMMENT_COLOR = new Color(Display.getCurrent(), new RGB(63, 127, 95));
  private static Color keyworldColor = new Color(Display.getCurrent(), new RGB(127, 00, 85));
  private static Color stringColor = new Color(Display.getCurrent(), new RGB(42, 00, 255));
  private static Color BlockColor = new Color(Display.getCurrent(), new RGB(0, 128, 255));
  private static Color purpleStringColor = new Color(Display.getCurrent(), new RGB(134, 107, 255));
  private static Color backquoteColor = new Color(Display.getCurrent(), new RGB(255, 72, 30));


  public ExampleRuleScanner() {
    artRules();
  }

  public void artRules() {
    IToken commentToken = new Token(new TextAttribute(COMMENT_COLOR));
    IToken keyword = new Token(new TextAttribute(keyworldColor));
    IToken stringToken = new Token(new TextAttribute(stringColor));
    IToken block = new Token(new TextAttribute(BlockColor));
    IToken darkStringToken = new Token(new TextAttribute(purpleStringColor));
    IToken backquoteToken = new Token(new TextAttribute(backquoteColor));


    List<IRule> rules = new ArrayList<IRule>();
    IWordDetector iWordDetector = new IWordDetector() {
      @Override
      public boolean isWordStart(char arg0) {
        // return false;
        return Character.isLetter(arg0);
      }

      @Override
      public boolean isWordPart(char arg0) {
        return Character.isLetter(arg0) || arg0 == '_';
      }
    };
    rules.add(new EndOfLineRule("!", commentToken));

    rules.add(new WordPatternRule(iWordDetector, "and", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "alias", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "backward", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "bool", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "case", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "connect", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "const", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "default", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "div", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "do", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "else", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "elseif", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "end", "", block));
    rules.add(new WordPatternRule(iWordDetector, "error", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "exit", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "FALSE", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "for", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "from", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "function", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "goto", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "if", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "local", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "module", "", block));
    rules.add(new WordPatternRule(iWordDetector, "mod", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "not", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "num", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "or", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "pers", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "private", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "public", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "raise", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "record", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "retry", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "return", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "step", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "string", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "switch", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "task", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "then", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "trap", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "TRUE", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "trynext", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "undo", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "var", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "void", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "while", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "with", "", keyword));
    rules.add(new WordPatternRule(iWordDetector, "xor", "", keyword));

    rules.add(new SingleLineRule("\"", "\"", stringToken));



    setRules(rules.toArray(new IRule[rules.size()]));
    return;
  }
}
