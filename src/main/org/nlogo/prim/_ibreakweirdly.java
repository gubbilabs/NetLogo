package org.nlogo.prim;

import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;
import org.nlogo.api.ReporterTask;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.EngineException;

public class _ibreakweirdly extends Command {

  @Override public Syntax syntax() {
    return Syntax.commandSyntax(
        new int[]{Syntax.StringType(), Syntax.ReporterTaskType()},
        "O---", true);
  }

  @Override public void perform(final Context context) throws LogoException {
    final String title = argEvalString(context, 0);
    final ReporterTask patchReporterTask = argEvalReporterTask(context, 1);
    System.out.println("So weird " + title + " " + patchReporterTask);
    context.ip = next;
  }
}
