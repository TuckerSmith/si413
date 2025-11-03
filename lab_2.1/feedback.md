lab2.1 result for Tucker Smith: REVISE

Auto-check script outputs:
yaml_errors:
    pass
yaml_missing:
    pass

Thanks for working with me to get this finally submitted
correctly.

I like the idea of your language, but you need to do some
more work on the formal specification with tokens and grammar.

First let's talk about the "log" part of your syntax.
It looks like the intention is for that to be a comment
in the language - you should explain that under "semantics"!

And then remember we learned that comments and whitespace are
typically recognized and ignored by the Scanner, which means they
should be *invisible* to the Parser. In your specs, what that
means is that log shouldn't be a CMD token, because it's not a
command at all. Rather, the whole comment line starting with the
"log" should be its own regex, and use -- as the token name to
indicate that it should be ignored by the scanner and not passed
on to the parser.

This will actually help you simplify the grammar, because I think
you can get rid of the OptionalLog nonterminal entirely.

OK now more generally, in your grammar, I see things like

  SinglePayloadCommand -> 1MC < Payload >

We should not see these operators like < and > in a grammar.
Everything in the grammar should be either a token name like
CMD or CMD_START, or a nonterminal like Payload. You are mixing
literal token *descriptions* into the grammar here. But instead,
you should only put the token descriptions in the token spec, and
then use those token names in your grammar.

Your submitted YAML file submitted (if any) is attached to this email,
for future reference. If you have any questions or want to meet for EI,
just shoot me an email or go to https://roche.work/howto.php?ei

-Dr Roche