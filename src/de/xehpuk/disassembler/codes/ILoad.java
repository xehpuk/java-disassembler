package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ILoad extends ILoadAbstract {
	protected ILoad(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ILOAD;
	}
}