package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IStore1 extends IStoreAbstract {
	protected IStore1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ISTORE_1;
	}
}