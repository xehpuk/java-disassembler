package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DLoad extends DLoadAbstract {
	protected DLoad(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DLOAD;
	}
}