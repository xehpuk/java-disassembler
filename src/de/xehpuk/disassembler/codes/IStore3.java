package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IStore3 extends IStoreAbstract {
	protected IStore3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ISTORE_3;
	}
}