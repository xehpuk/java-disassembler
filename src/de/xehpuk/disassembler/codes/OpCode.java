package de.xehpuk.disassembler.codes;

import de.xehpuk.disassembler.exceptions.IllegalOpCodeException;
import de.xehpuk.disassembler.reader.AttributesReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xehpuk
 */
public enum OpCode {
	NOP((byte) 0x00, 0) {
		@Override
		public NOp read(final AttributesReader reader) {
			return NOp.INSTANCE;
		}
	},
	ACONST_NULL((byte) 0x01, 0) {
		@Override
		public AConstNull read(final AttributesReader reader) {
			return AConstNull.INSTANCE;
		}
	},
	ICONST_M1((byte) 0x02, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_M1;
		}
	},
	ICONST_0((byte) 0x03, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_0;
		}
	},
	ICONST_1((byte) 0x04, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_1;
		}
	},
	ICONST_2((byte) 0x05, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_2;
		}
	},
	ICONST_3((byte) 0x06, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_3;
		}
	},
	ICONST_4((byte) 0x07, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_4;
		}
	},
	ICONST_5((byte) 0x08, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.ICONST_5;
		}
	},
	LCONST_0((byte) 0x09, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.LCONST_0;
		}
	},
	LCONST_1((byte) 0x0A, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.LCONST_1;
		}
	},
	FCONST_0((byte) 0x0B, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.FCONST_0;
		}
	},
	FCONST_1((byte) 0x0C, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.FCONST_1;
		}
	},
	FCONST_2((byte) 0x0D, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.FCONST_2;
		}
	},
	DCONST_0((byte) 0x0E, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.DCONST_0;
		}
	},
	DCONST_1((byte) 0x0F, 0) {
		@Override
		public ImplicitConstant read(final AttributesReader reader) {
			return ImplicitConstant.DCONST_1;
		}
	},
	BIPUSH((byte) 0x10, 1) {
		@Override
		public BIPush read(final AttributesReader reader) throws IOException {
			final byte constant = reader.readByte();
			return new BIPush(constant);
		}
	},
	SIPUSH((byte) 0x11, 2) {
		@Override
		public SIPush read(final AttributesReader reader) throws IOException {
			final short constant = reader.readShort();
			return new SIPush(constant);
		}
	},
	LDC((byte) 0x12, 1) {
		@Override
		public LdC read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new LdC(index);
		}
	},
	LDC_W((byte) 0x13, 2) {
		@Override
		public LdCW read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new LdCW(index);
		}
	},
	LDC2_W((byte) 0x14, 2) {
		@Override
		public LdC2W read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new LdC2W(index);
		}
	},
	ILOAD((byte) 0x15, 1) {
		@Override
		public ILoad read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new ILoad(index);
		}
	},
	LLOAD((byte) 0x16, 1) {
		@Override
		public LLoad read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new LLoad(index);
		}
	},
	FLOAD((byte) 0x17, 1) {
		@Override
		public FLoad read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new FLoad(index);
		}
	},
	DLOAD((byte) 0x18, 1) {
		@Override
		public DLoad read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new DLoad(index);
		}
	},
	ALOAD((byte) 0x19, 1) {
		@Override
		public ALoad read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new ALoad(index);
		}
	},
	ILOAD_0((byte) 0x1A, 0) {
		@Override
		public ILoad0 read(final AttributesReader reader) {
			return new ILoad0();
		}
	},
	ILOAD_1((byte) 0x1B, 0) {
		@Override
		public ILoad1 read(final AttributesReader reader) {
			return new ILoad1();
		}
	},
	ILOAD_2((byte) 0x1C, 0) {
		@Override
		public ILoad2 read(final AttributesReader reader) {
			return new ILoad2();
		}
	},
	ILOAD_3((byte) 0x1D, 0) {
		@Override
		public ILoad3 read(final AttributesReader reader) {
			return new ILoad3();
		}
	},
	LLOAD_0((byte) 0x1E, 0) {
		@Override
		public LLoad0 read(final AttributesReader reader) {
			return new LLoad0();
		}
	},
	LLOAD_1((byte) 0x1F, 0) {
		@Override
		public LLoad1 read(final AttributesReader reader) {
			return new LLoad1();
		}
	},
	LLOAD_2((byte) 0x20, 0) {
		@Override
		public LLoad2 read(final AttributesReader reader) {
			return new LLoad2();
		}
	},
	LLOAD_3((byte) 0x21, 0) {
		@Override
		public LLoad3 read(final AttributesReader reader) {
			return new LLoad3();
		}
	},
	FLOAD_0((byte) 0x22, 0) {
		@Override
		public FLoad0 read(final AttributesReader reader) {
			return new FLoad0();
		}
	},
	FLOAD_1((byte) 0x23, 0) {
		@Override
		public FLoad1 read(final AttributesReader reader) {
			return new FLoad1();
		}
	},
	FLOAD_2((byte) 0x24, 0) {
		@Override
		public FLoad2 read(final AttributesReader reader) {
			return new FLoad2();
		}
	},
	FLOAD_3((byte) 0x25, 0) {
		@Override
		public FLoad3 read(final AttributesReader reader) {
			return new FLoad3();
		}
	},
	DLOAD_0((byte) 0x26, 0) {
		@Override
		public DLoad0 read(final AttributesReader reader) {
			return new DLoad0();
		}
	},
	DLOAD_1((byte) 0x27, 0) {
		@Override
		public DLoad1 read(final AttributesReader reader) {
			return new DLoad1();
		}
	},
	DLOAD_2((byte) 0x28, 0) {
		@Override
		public DLoad2 read(final AttributesReader reader) {
			return new DLoad2();
		}
	},
	DLOAD_3((byte) 0x29, 0) {
		@Override
		public DLoad3 read(final AttributesReader reader) {
			return new DLoad3();
		}
	},
	ALOAD_0((byte) 0x2A, 0) {
		@Override
		public ALoad0 read(final AttributesReader reader) {
			return new ALoad0();
		}
	},
	ALOAD_1((byte) 0x2B, 0) {
		@Override
		public ALoad1 read(final AttributesReader reader) {
			return new ALoad1();
		}
	},
	ALOAD_2((byte) 0x2C, 0) {
		@Override
		public ALoad2 read(final AttributesReader reader) {
			return new ALoad2();
		}
	},
	ALOAD_3((byte) 0x2D, 0) {
		@Override
		public ALoad3 read(final AttributesReader reader) {
			return new ALoad3();
		}
	},
	IALOAD((byte) 0x2E, 0) {
		@Override
		public IALoad read(final AttributesReader reader) {
			return new IALoad();
		}
	},
	LALOAD((byte) 0x2F, 0) {
		@Override
		public LALoad read(final AttributesReader reader) {
			return new LALoad();
		}
	},
	FALOAD((byte) 0x30, 0) {
		@Override
		public FALoad read(final AttributesReader reader) {
			return new FALoad();
		}
	},
	DALOAD((byte) 0x31, 0) {
		@Override
		public DALoad read(final AttributesReader reader) {
			return new DALoad();
		}
	},
	AALOAD((byte) 0x32, 0) {
		@Override
		public AALoad read(final AttributesReader reader) {
			return new AALoad();
		}
	},
	BALOAD((byte) 0x33, 0) {
		@Override
		public BALoad read(final AttributesReader reader) {
			return new BALoad();
		}
	},
	CALOAD((byte) 0x34, 0) {
		@Override
		public CALoad read(final AttributesReader reader) {
			return new CALoad();
		}
	},
	SALOAD((byte) 0x35, 0) {
		@Override
		public SALoad read(final AttributesReader reader) {
			return new SALoad();
		}
	},
	ISTORE((byte) 0x36, 1) {
		@Override
		public IStore read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new IStore(index);
		}
	},
	LSTORE((byte) 0x37, 1) {
		@Override
		public LStore read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new LStore(index);
		}
	},
	FSTORE((byte) 0x38, 1) {
		@Override
		public FStore read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new FStore(index);
		}
	},
	DSTORE((byte) 0x39, 1) {
		@Override
		public DStore read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new DStore(index);
		}
	},
	ASTORE((byte) 0x3A, 1) {
		@Override
		public AStore read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new AStore(index);
		}
	},
	ISTORE_0((byte) 0x3B, 0) {
		@Override
		public IStore0 read(final AttributesReader reader) {
			return new IStore0();
		}
	},
	ISTORE_1((byte) 0x3C, 0) {
		@Override
		public IStore1 read(final AttributesReader reader) {
			return new IStore1();
		}
	},
	ISTORE_2((byte) 0x3D, 0) {
		@Override
		public IStore2 read(final AttributesReader reader) {
			return new IStore2();
		}
	},
	ISTORE_3((byte) 0x3E, 0) {
		@Override
		public IStore3 read(final AttributesReader reader) {
			return new IStore3();
		}
	},
	LSTORE_0((byte) 0x3F, 0) {
		@Override
		public LStore0 read(final AttributesReader reader) {
			return new LStore0();
		}
	},
	LSTORE_1((byte) 0x40, 0) {
		@Override
		public LStore1 read(final AttributesReader reader) {
			return new LStore1();
		}
	},
	LSTORE_2((byte) 0x41, 0) {
		@Override
		public LStore2 read(final AttributesReader reader) {
			return new LStore2();
		}
	},
	LSTORE_3((byte) 0x42, 0) {
		@Override
		public LStore3 read(final AttributesReader reader) {
			return new LStore3();
		}
	},
	FSTORE_0((byte) 0x43, 0) {
		@Override
		public FStore0 read(final AttributesReader reader) {
			return new FStore0();
		}
	},
	FSTORE_1((byte) 0x44, 0) {
		@Override
		public FStore1 read(final AttributesReader reader) {
			return new FStore1();
		}
	},
	FSTORE_2((byte) 0x45, 0) {
		@Override
		public FStore2 read(final AttributesReader reader) {
			return new FStore2();
		}
	},
	FSTORE_3((byte) 0x46, 0) {
		@Override
		public FStore3 read(final AttributesReader reader) {
			return new FStore3();
		}
	},
	DSTORE_0((byte) 0x47, 0) {
		@Override
		public DStore0 read(final AttributesReader reader) {
			return new DStore0();
		}
	},
	DSTORE_1((byte) 0x48, 0) {
		@Override
		public DStore1 read(final AttributesReader reader) {
			return new DStore1();
		}
	},
	DSTORE_2((byte) 0x49, 0) {
		@Override
		public DStore2 read(final AttributesReader reader) {
			return new DStore2();
		}
	},
	DSTORE_3((byte) 0x4A, 0) {
		@Override
		public DStore3 read(final AttributesReader reader) {
			return new DStore3();
		}
	},
	ASTORE_0((byte) 0x4B, 0) {
		@Override
		public AStore0 read(final AttributesReader reader) {
			return new AStore0();
		}
	},
	ASTORE_1((byte) 0x4C, 0) {
		@Override
		public AStore1 read(final AttributesReader reader) {
			return new AStore1();
		}
	},
	ASTORE_2((byte) 0x4D, 0) {
		@Override
		public AStore2 read(final AttributesReader reader) {
			return new AStore2();
		}
	},
	ASTORE_3((byte) 0x4E, 0) {
		@Override
		public AStore3 read(final AttributesReader reader) {
			return new AStore3();
		}
	},
	IASTORE((byte) 0x4F, 0) {
		@Override
		public IAStore read(final AttributesReader reader) {
			return new IAStore();
		}
	},
	LASTORE((byte) 0x50, 0) {
		@Override
		public LAStore read(final AttributesReader reader) {
			return new LAStore();
		}
	},
	FASTORE((byte) 0x51, 0) {
		@Override
		public FAStore read(final AttributesReader reader) {
			return new FAStore();
		}
	},
	DASTORE((byte) 0x52, 0) {
		@Override
		public DAStore read(final AttributesReader reader) {
			return new DAStore();
		}
	},
	AASTORE((byte) 0x53, 0) {
		@Override
		public AAStore read(final AttributesReader reader) {
			return new AAStore();
		}
	},
	BASTORE((byte) 0x54, 0) {
		@Override
		public BAStore read(final AttributesReader reader) {
			return new BAStore();
		}
	},
	CASTORE((byte) 0x55, 0) {
		@Override
		public CAStore read(final AttributesReader reader) {
			return new CAStore();
		}
	},
	SASTORE((byte) 0x56, 0) {
		@Override
		public SAStore read(final AttributesReader reader) {
			return new SAStore();
		}
	},
	POP((byte) 0x57, 0) {
		@Override
		public Pop read(final AttributesReader reader) {
			return new Pop();
		}
	},
	POP2((byte) 0x58, 0) {
		@Override
		public Pop2 read(final AttributesReader reader) {
			return new Pop2();
		}
	},
	DUP((byte) 0x59, 0) {
		@Override
		public Dup read(final AttributesReader reader) {
			return new Dup();
		}
	},
	DUP_X1((byte) 0x5A, 0) {
		@Override
		public DupX1 read(final AttributesReader reader) {
			return new DupX1();
		}
	},
	DUP_X2((byte) 0x5B, 0) {
		@Override
		public DupX2 read(final AttributesReader reader) {
			return new DupX2();
		}
	},
	DUP2((byte) 0x5C, 0) {
		@Override
		public Dup2 read(final AttributesReader reader) {
			return new Dup2();
		}
	},
	DUP2_X1((byte) 0x5D, 0) {
		@Override
		public Dup2X1 read(final AttributesReader reader) {
			return new Dup2X1();
		}
	},
	DUP2_X2((byte) 0x5E, 0) {
		@Override
		public Dup2X2 read(final AttributesReader reader) {
			return new Dup2X2();
		}
	},
	SWAP((byte) 0x5F, 0) {
		@Override
		public Swap read(final AttributesReader reader) {
			return new Swap();
		}
	},
	IADD((byte) 0x60, 0) {
		@Override
		public IAdd read(final AttributesReader reader) {
			return new IAdd();
		}
	},
	LADD((byte) 0x61, 0) {
		@Override
		public LAdd read(final AttributesReader reader) {
			return new LAdd();
		}
	},
	FADD((byte) 0x62, 0) {
		@Override
		public FAdd read(final AttributesReader reader) {
			return new FAdd();
		}
	},
	DADD((byte) 0x63, 0) {
		@Override
		public DAdd read(final AttributesReader reader) {
			return new DAdd();
		}
	},
	ISUB((byte) 0x64, 0) {
		@Override
		public ISub read(final AttributesReader reader) {
			return new ISub();
		}
	},
	LSUB((byte) 0x65, 0) {
		@Override
		public LSub read(final AttributesReader reader) {
			return new LSub();
		}
	},
	FSUB((byte) 0x66, 0) {
		@Override
		public FSub read(final AttributesReader reader) {
			return new FSub();
		}
	},
	DSUB((byte) 0x67, 0) {
		@Override
		public DSub read(final AttributesReader reader) {
			return new DSub();
		}
	},
	IMUL((byte) 0x68, 0) {
		@Override
		public IMul read(final AttributesReader reader) {
			return new IMul();
		}
	},
	LMUL((byte) 0x69, 0) {
		@Override
		public LMul read(final AttributesReader reader) {
			return new LMul();
		}
	},
	FMUL((byte) 0x6A, 0) {
		@Override
		public FMul read(final AttributesReader reader) {
			return new FMul();
		}
	},
	DMUL((byte) 0x6B, 0) {
		@Override
		public DMul read(final AttributesReader reader) {
			return new DMul();
		}
	},
	IDIV((byte) 0x6C, 0) {
		@Override
		public IDiv read(final AttributesReader reader) {
			return new IDiv();
		}
	},
	LDIV((byte) 0x6D, 0) {
		@Override
		public LDiv read(final AttributesReader reader) {
			return new LDiv();
		}
	},
	FDIV((byte) 0x6E, 0) {
		@Override
		public FDiv read(final AttributesReader reader) {
			return new FDiv();
		}
	},
	DDIV((byte) 0x6F, 0) {
		@Override
		public DDiv read(final AttributesReader reader) {
			return new DDiv();
		}
	},
	IREM((byte) 0x70, 0) {
		@Override
		public IRem read(final AttributesReader reader) {
			return new IRem();
		}
	},
	LREM((byte) 0x71, 0) {
		@Override
		public LRem read(final AttributesReader reader) {
			return new LRem();
		}
	},
	FREM((byte) 0x72, 0) {
		@Override
		public FRem read(final AttributesReader reader) {
			return new FRem();
		}
	},
	DREM((byte) 0x73, 0) {
		@Override
		public DRem read(final AttributesReader reader) {
			return new DRem();
		}
	},
	INEG((byte) 0x74, 0) {
		@Override
		public INeg read(final AttributesReader reader) {
			return new INeg();
		}
	},
	LNEG((byte) 0x75, 0) {
		@Override
		public LNeg read(final AttributesReader reader) {
			return new LNeg();
		}
	},
	FNEG((byte) 0x76, 0) {
		@Override
		public FNeg read(final AttributesReader reader) {
			return new FNeg();
		}
	},
	DNEG((byte) 0x77, 0) {
		@Override
		public DNeg read(final AttributesReader reader) {
			return new DNeg();
		}
	},
	ISHL((byte) 0x78, 0) {
		@Override
		public IShL read(final AttributesReader reader) {
			return new IShL();
		}
	},
	LSHL((byte) 0x79, 0) {
		@Override
		public LShL read(final AttributesReader reader) {
			return new LShL();
		}
	},
	ISHR((byte) 0x7A, 0) {
		@Override
		public IShR read(final AttributesReader reader) {
			return new IShR();
		}
	},
	LSHR((byte) 0x7B, 0) {
		@Override
		public LShR read(final AttributesReader reader) {
			return new LShR();
		}
	},
	IUSHR((byte) 0x7C, 0) {
		@Override
		public IUShR read(final AttributesReader reader) {
			return new IUShR();
		}
	},
	LUSHR((byte) 0x7D, 0) {
		@Override
		public LUShR read(final AttributesReader reader) {
			return new LUShR();
		}
	},
	IAND((byte) 0x7E, 0) {
		@Override
		public IAnd read(final AttributesReader reader) {
			return new IAnd();
		}
	},
	LAND((byte) 0x7F, 0) {
		@Override
		public LAnd read(final AttributesReader reader) {
			return new LAnd();
		}
	},
	IOR((byte) 0x80, 0) {
		@Override
		public IOr read(final AttributesReader reader) {
			return new IOr();
		}
	},
	LOR((byte) 0x81, 0) {
		@Override
		public LOr read(final AttributesReader reader) {
			return new LOr();
		}
	},
	IXOR((byte) 0x82, 0) {
		@Override
		public IXOr read(final AttributesReader reader) {
			return new IXOr();
		}
	},
	LXOR((byte) 0x83, 0) {
		@Override
		public LXOr read(final AttributesReader reader) {
			return new LXOr();
		}
	},
	IINC((byte) 0x84, 2) {
		@Override
		public IInc read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			final byte constant = reader.readByte();
			return new IInc(index, constant);
		}
	},
	I2L((byte) 0x85, 0) {
		@Override
		public I2L read(final AttributesReader reader) {
			return new I2L();
		}
	},
	I2F((byte) 0x86, 0) {
		@Override
		public I2F read(final AttributesReader reader) {
			return new I2F();
		}
	},
	I2D((byte) 0x87, 0) {
		@Override
		public I2D read(final AttributesReader reader) {
			return new I2D();
		}
	},
	L2I((byte) 0x88, 0) {
		@Override
		public L2I read(final AttributesReader reader) {
			return new L2I();
		}
	},
	L2F((byte) 0x89, 0) {
		@Override
		public L2F read(final AttributesReader reader) {
			return new L2F();
		}
	},
	L2D((byte) 0x8A, 0) {
		@Override
		public L2D read(final AttributesReader reader) {
			return new L2D();
		}
	},
	F2I((byte) 0x8B, 0) {
		@Override
		public F2I read(final AttributesReader reader) {
			return new F2I();
		}
	},
	F2L((byte) 0x8C, 0) {
		@Override
		public F2L read(final AttributesReader reader) {
			return new F2L();
		}
	},
	F2D((byte) 0x8D, 0) {
		@Override
		public F2D read(final AttributesReader reader) {
			return new F2D();
		}
	},
	D2I((byte) 0x8E, 0) {
		@Override
		public D2I read(final AttributesReader reader) {
			return new D2I();
		}
	},
	D2L((byte) 0x8F, 0) {
		@Override
		public D2L read(final AttributesReader reader) {
			return new D2L();
		}
	},
	D2F((byte) 0x90, 0) {
		@Override
		public D2F read(final AttributesReader reader) {
			return new D2F();
		}
	},
	I2B((byte) 0x91, 0) {
		@Override
		public I2B read(final AttributesReader reader) {
			return new I2B();
		}
	},
	I2C((byte) 0x92, 0) {
		@Override
		public I2C read(final AttributesReader reader) {
			return new I2C();
		}
	},
	I2S((byte) 0x93, 0) {
		@Override
		public I2S read(final AttributesReader reader) {
			return new I2S();
		}
	},
	LCMP((byte) 0x94, 0) {
		@Override
		public LCmp read(final AttributesReader reader) {
			return new LCmp();
		}
	},
	FCMPL((byte) 0x95, 0) {
		@Override
		public FCmpL read(final AttributesReader reader) {
			return new FCmpL();
		}
	},
	FCMPG((byte) 0x96, 0) {
		@Override
		public FCmpG read(final AttributesReader reader) {
			return new FCmpG();
		}
	},
	DCMPL((byte) 0x97, 0) {
		@Override
		public DCmpL read(final AttributesReader reader) {
			return new DCmpL();
		}
	},
	DCMPG((byte) 0x98, 0) {
		@Override
		public DCmpG read(final AttributesReader reader) {
			return new DCmpG();
		}
	},
	IFEQ((byte) 0x99, 2) {
		@Override
		public IfEq read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfEq(offset);
		}
	},
	IFNE((byte) 0x9A, 2) {
		@Override
		public IfNE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfNE(offset);
		}
	},
	IFLT((byte) 0x9B, 2) {
		@Override
		public IfLT read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfLT(offset);
		}
	},
	IFGE((byte) 0x9C, 2) {
		@Override
		public IfGE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfGE(offset);
		}
	},
	IFGT((byte) 0x9D, 2) {
		@Override
		public IfGT read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfGT(offset);
		}
	},
	IFLE((byte) 0x9E, 2) {
		@Override
		public IfLE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfLE(offset);
		}
	},
	IF_ICMPEQ((byte) 0x9F, 2) {
		@Override
		public IfICmpEq read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpEq(offset);
		}
	},
	IF_ICMPNE((byte) 0xA0, 2) {
		@Override
		public IfICmpNE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpNE(offset);
		}
	},
	IF_ICMPLT((byte) 0xA1, 2) {
		@Override
		public IfICmpLT read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpLT(offset);
		}
	},
	IF_ICMPGE((byte) 0xA2, 2) {
		@Override
		public IfICmpGE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpGE(offset);
		}
	},
	IF_ICMPGT((byte) 0xA3, 2) {
		@Override
		public IfICmpGT read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpGT(offset);
		}
	},
	IF_ICMPLE((byte) 0xA4, 2) {
		@Override
		public IfICmpLE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfICmpLE(offset);
		}
	},
	IF_ACMPEQ((byte) 0xA5, 2) {
		@Override
		public IfACmpEq read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfACmpEq(offset);
		}
	},
	IF_ACMPNE((byte) 0xA6, 2) {
		@Override
		public IfACmpNE read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfACmpNE(offset);
		}
	},
	GOTO((byte) 0xA7, 2) {
		@Override
		public Goto read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new Goto(offset);
		}
	},
	JSR((byte) 0xA8, 2) {
		@Override
		public JSr read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new JSr(offset);
		}
	},
	RET((byte) 0xA9, 1) {
		@Override
		public Ret read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedByte();
			return new Ret(index);
		}
	},
	TABLESWITCH((byte) 0xAA, 12) {
		@Override
		public TableSwitch read(final AttributesReader reader) throws IOException {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}, // FIXME variable-length instruction
	LOOKUPSWITCH((byte) 0xAB, 8) {
		@Override
		public LookupSwitch read(final AttributesReader reader) throws IOException {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}, // FIXME variable-length instruction
	IRETURN((byte) 0xAC, 0) {
		@Override
		public IReturn read(final AttributesReader reader) {
			return new IReturn();
		}
	},
	LRETURN((byte) 0xAD, 0) {
		@Override
		public LReturn read(final AttributesReader reader) {
			return new LReturn();
		}
	},
	FRETURN((byte) 0xAE, 0) {
		@Override
		public FReturn read(final AttributesReader reader) {
			return new FReturn();
		}
	},
	DRETURN((byte) 0xAF, 0) {
		@Override
		public DReturn read(final AttributesReader reader) {
			return new DReturn();
		}
	},
	ARETURN((byte) 0xB0, 0) {
		@Override
		public AReturn read(final AttributesReader reader) {
			return new AReturn();
		}
	},
	RETURN((byte) 0xB1, 0) {
		@Override
		public Return read(final AttributesReader reader) {
			return new Return();
		}
	},
	GETSTATIC((byte) 0xB2, 2) {
		@Override
		public GetStatic read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new GetStatic(index);
		}
	},
	PUTSTATIC((byte) 0xB3, 2) {
		@Override
		public PutStatic read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new PutStatic(index);
		}
	},
	GETFIELD((byte) 0xB4, 2) {
		@Override
		public GetField read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new GetField(index);
		}
	},
	PUTFIELD((byte) 0xB5, 2) {
		@Override
		public PutField read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new PutField(index);
		}
	},
	INVOKEVIRTUAL((byte) 0xB6, 2) {
		@Override
		public InvokeVirtual read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new InvokeVirtual(index);
		}
	},
	INVOKESPECIAL((byte) 0xB7, 2) {
		@Override
		public InvokeSpecial read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new InvokeSpecial(index);
		}
	},
	INVOKESTATIC((byte) 0xB8, 2) {
		@Override
		public InvokeStatic read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new InvokeStatic(index);
		}
	},
	INVOKEINTERFACE((byte) 0xB9, 4) {
		@Override
		public InvokeInterface read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			final int count = reader.readUnsignedByte();
			final byte zero = reader.readByte(); // TODO has to be zero
			return new InvokeInterface(index, count);
		}
	},
	INVOKEDYNAMIC((byte) 0xBA, 4) {
		@Override
		public InvokeDynamic read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			final short zero = reader.readShort(); // TODO has to be zero
			return new InvokeDynamic(index);
		}
	},
	NEW((byte) 0xBB, 2) {
		@Override
		public New read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new New(index);
		}
	},
	NEWARRAY((byte) 0xBC, 1) {
		@Override
		public Instruction read(final AttributesReader reader) throws IOException {
			final byte code = reader.readByte();
			return new NewArray(ArrayType.from(code));
		}
	},
	ANEWARRAY((byte) 0xBD, 2) {
		@Override
		public ANewArray read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new ANewArray(index);
		}
	},
	ARRAYLENGTH((byte) 0xBE, 0) {
		@Override
		public ArrayLength read(final AttributesReader reader) {
			return new ArrayLength();
		}
	},
	ATHROW((byte) 0xBF, 0) {
		@Override
		public AThrow read(final AttributesReader reader) {
			return new AThrow();
		}
	},
	CHECKCAST((byte) 0xC0, 2) {
		@Override
		public CheckCast read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new CheckCast(index);
		}
	},
	INSTANCEOF((byte) 0xC1, 2) {
		@Override
		public InstanceOf read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			return new InstanceOf(index);
		}
	},
	MONITORENTER((byte) 0xC2, 0) {
		@Override
		public MonitorEnter read(final AttributesReader reader) {
			return new MonitorEnter();
		}
	},
	MONITOREXIT((byte) 0xC3, 0) {
		@Override
		public MonitorExit read(final AttributesReader reader) {
			return new MonitorExit();
		}
	},
	WIDE((byte) 0xC4, 3) {
		@Override
		public Instruction read(final AttributesReader reader) throws IOException {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}, // FIXME 3 or 5 bytes? two formats
	MULTIANEWARRAY((byte) 0xC5, 3) {
		@Override
		public MultiANewArray read(final AttributesReader reader) throws IOException {
			final int index = reader.readUnsignedShort();
			final int dimensions = reader.readUnsignedByte();
			return new MultiANewArray(index, dimensions);
		}
	},
	IFNULL((byte) 0xC6, 2) {
		@Override
		public IfNull read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfNull(offset);
		}
	},
	IFNONNULL((byte) 0xC7, 2) {
		@Override
		public IfNonNull read(final AttributesReader reader) throws IOException {
			final short offset = reader.readShort();
			return new IfNonNull(offset);
		}
	},
	GOTO_W((byte) 0xC8, 4) {
		@Override
		public GotoW read(final AttributesReader reader) throws IOException {
			final int offset = reader.readInt();
			return new GotoW(offset);
		}
	},
	JSR_W((byte) 0xC9, 4) {
		@Override
		public JSrW read(final AttributesReader reader) throws IOException {
			final int offset = reader.readInt();
			return new JSrW(offset);
		}
	};
	private static final Map<Byte, OpCode> codeLookup = new HashMap<>(values().length);

	static {
		for (final OpCode code : values()) {
			if (codeLookup.put(code.getCode(), code) != null) {
				throw new IllegalOpCodeException(code.getCode());
			}
		}
	}

	public static OpCode from(final byte code) throws IllegalOpCodeException {
		final OpCode result = codeLookup.get(code);
		if (result == null) {
			throw new IllegalOpCodeException(code);
		}
		return result;
	}
	private final byte code;
	private final int numberOfArguments;

	private OpCode(final byte code, final int numberOfArguments) {
		this.code = code;
		this.numberOfArguments = numberOfArguments;
	}

	public byte getCode() {
		return code;
	}

	public int getNumberOfArguments() {
		return numberOfArguments;
	}
	
	public abstract Instruction read(AttributesReader reader) throws IOException;
}