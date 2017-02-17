/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.berkeley.cs.zipg;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-02-16")
public class RPQCtx implements org.apache.thrift.TBase<RPQCtx, RPQCtx._Fields>, java.io.Serializable, Cloneable, Comparable<RPQCtx> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RPQCtx");

  private static final org.apache.thrift.protocol.TField ENDPOINTS_FIELD_DESC = new org.apache.thrift.protocol.TField("endpoints", org.apache.thrift.protocol.TType.SET, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RPQCtxStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RPQCtxTupleSchemeFactory();

  public java.util.Set<Path> endpoints; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ENDPOINTS((short)1, "endpoints");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ENDPOINTS
          return ENDPOINTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ENDPOINTS, new org.apache.thrift.meta_data.FieldMetaData("endpoints", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Path.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RPQCtx.class, metaDataMap);
  }

  public RPQCtx() {
  }

  public RPQCtx(
    java.util.Set<Path> endpoints)
  {
    this();
    this.endpoints = endpoints;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RPQCtx(RPQCtx other) {
    if (other.isSetEndpoints()) {
      java.util.Set<Path> __this__endpoints = new java.util.HashSet<Path>(other.endpoints.size());
      for (Path other_element : other.endpoints) {
        __this__endpoints.add(new Path(other_element));
      }
      this.endpoints = __this__endpoints;
    }
  }

  public RPQCtx deepCopy() {
    return new RPQCtx(this);
  }

  @Override
  public void clear() {
    this.endpoints = null;
  }

  public int getEndpointsSize() {
    return (this.endpoints == null) ? 0 : this.endpoints.size();
  }

  public java.util.Iterator<Path> getEndpointsIterator() {
    return (this.endpoints == null) ? null : this.endpoints.iterator();
  }

  public void addToEndpoints(Path elem) {
    if (this.endpoints == null) {
      this.endpoints = new java.util.HashSet<Path>();
    }
    this.endpoints.add(elem);
  }

  public java.util.Set<Path> getEndpoints() {
    return this.endpoints;
  }

  public RPQCtx setEndpoints(java.util.Set<Path> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public void unsetEndpoints() {
    this.endpoints = null;
  }

  /** Returns true if field endpoints is set (has been assigned a value) and false otherwise */
  public boolean isSetEndpoints() {
    return this.endpoints != null;
  }

  public void setEndpointsIsSet(boolean value) {
    if (!value) {
      this.endpoints = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ENDPOINTS:
      if (value == null) {
        unsetEndpoints();
      } else {
        setEndpoints((java.util.Set<Path>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ENDPOINTS:
      return getEndpoints();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ENDPOINTS:
      return isSetEndpoints();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RPQCtx)
      return this.equals((RPQCtx)that);
    return false;
  }

  public boolean equals(RPQCtx that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_endpoints = true && this.isSetEndpoints();
    boolean that_present_endpoints = true && that.isSetEndpoints();
    if (this_present_endpoints || that_present_endpoints) {
      if (!(this_present_endpoints && that_present_endpoints))
        return false;
      if (!this.endpoints.equals(that.endpoints))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEndpoints()) ? 131071 : 524287);
    if (isSetEndpoints())
      hashCode = hashCode * 8191 + endpoints.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RPQCtx other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetEndpoints()).compareTo(other.isSetEndpoints());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndpoints()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endpoints, other.endpoints);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RPQCtx(");
    boolean first = true;

    sb.append("endpoints:");
    if (this.endpoints == null) {
      sb.append("null");
    } else {
      sb.append(this.endpoints);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RPQCtxStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RPQCtxStandardScheme getScheme() {
      return new RPQCtxStandardScheme();
    }
  }

  private static class RPQCtxStandardScheme extends org.apache.thrift.scheme.StandardScheme<RPQCtx> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RPQCtx struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ENDPOINTS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set16 = iprot.readSetBegin();
                struct.endpoints = new java.util.HashSet<Path>(2*_set16.size);
                Path _elem17;
                for (int _i18 = 0; _i18 < _set16.size; ++_i18)
                {
                  _elem17 = new Path();
                  _elem17.read(iprot);
                  struct.endpoints.add(_elem17);
                }
                iprot.readSetEnd();
              }
              struct.setEndpointsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RPQCtx struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.endpoints != null) {
        oprot.writeFieldBegin(ENDPOINTS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.endpoints.size()));
          for (Path _iter19 : struct.endpoints)
          {
            _iter19.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RPQCtxTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RPQCtxTupleScheme getScheme() {
      return new RPQCtxTupleScheme();
    }
  }

  private static class RPQCtxTupleScheme extends org.apache.thrift.scheme.TupleScheme<RPQCtx> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RPQCtx struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEndpoints()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetEndpoints()) {
        {
          oprot.writeI32(struct.endpoints.size());
          for (Path _iter20 : struct.endpoints)
          {
            _iter20.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RPQCtx struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set21 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.endpoints = new java.util.HashSet<Path>(2*_set21.size);
          Path _elem22;
          for (int _i23 = 0; _i23 < _set21.size; ++_i23)
          {
            _elem22 = new Path();
            _elem22.read(iprot);
            struct.endpoints.add(_elem22);
          }
        }
        struct.setEndpointsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

