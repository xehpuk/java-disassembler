package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LLoad extends LLoadAbstract {
	protected LLoad(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LLOAD;
	}
}