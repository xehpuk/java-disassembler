package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.ConstantBootstrapArgumentType;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodHandle;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class BootstrapMethodsTableEntry implements Dumpable {
	private final ConstantMethodHandle<?> bootstrapMethod;
	private final ConstantBootstrapArgumentType[] bootstrapArguments;

	public BootstrapMethodsTableEntry(final ConstantMethodHandle<?> bootstrapMethod, final ConstantBootstrapArgumentType[] bootstrapArguments) {
		this.bootstrapMethod = bootstrapMethod;
		this.bootstrapArguments = bootstrapArguments;
	}

	public ConstantMethodHandle<?> getBootstrapMethod() {
		return bootstrapMethod;
	}

	public ConstantBootstrapArgumentType[] getBootstrapArguments() {
		return bootstrapArguments;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		bootstrapMethod.dump(0);
		for (int i = 0; i < bootstrapArguments.length; i++) {
			System.out.print(i == 0 ? ':' : ',');
			System.out.print(' ');
			final ConstantBootstrapArgumentType constantBootstrapArgumentType = bootstrapArguments[i];
			constantBootstrapArgumentType.dump(0);
		}
		System.out.println();
	}
}