/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "succinct_graph_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>




ThriftAssoc::~ThriftAssoc() throw() {
}


void ThriftAssoc::__set_srcId(const int64_t val) {
  this->srcId = val;
}

void ThriftAssoc::__set_dstId(const int64_t val) {
  this->dstId = val;
}

void ThriftAssoc::__set_atype(const int64_t val) {
  this->atype = val;
}

void ThriftAssoc::__set_timestamp(const int64_t val) {
  this->timestamp = val;
}

void ThriftAssoc::__set_attr(const std::string& val) {
  this->attr = val;
}

uint32_t ThriftAssoc::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->srcId);
          this->__isset.srcId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->dstId);
          this->__isset.dstId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->atype);
          this->__isset.atype = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->timestamp);
          this->__isset.timestamp = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->attr);
          this->__isset.attr = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t ThriftAssoc::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("ThriftAssoc");

  xfer += oprot->writeFieldBegin("srcId", ::apache::thrift::protocol::T_I64, 1);
  xfer += oprot->writeI64(this->srcId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("dstId", ::apache::thrift::protocol::T_I64, 2);
  xfer += oprot->writeI64(this->dstId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("atype", ::apache::thrift::protocol::T_I64, 3);
  xfer += oprot->writeI64(this->atype);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("timestamp", ::apache::thrift::protocol::T_I64, 4);
  xfer += oprot->writeI64(this->timestamp);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("attr", ::apache::thrift::protocol::T_STRING, 5);
  xfer += oprot->writeString(this->attr);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ThriftAssoc &a, ThriftAssoc &b) {
  using ::std::swap;
  swap(a.srcId, b.srcId);
  swap(a.dstId, b.dstId);
  swap(a.atype, b.atype);
  swap(a.timestamp, b.timestamp);
  swap(a.attr, b.attr);
  swap(a.__isset, b.__isset);
}

ThriftAssoc::ThriftAssoc(const ThriftAssoc& other0) {
  srcId = other0.srcId;
  dstId = other0.dstId;
  atype = other0.atype;
  timestamp = other0.timestamp;
  attr = other0.attr;
  __isset = other0.__isset;
}
ThriftAssoc& ThriftAssoc::operator=(const ThriftAssoc& other1) {
  srcId = other1.srcId;
  dstId = other1.dstId;
  atype = other1.atype;
  timestamp = other1.timestamp;
  attr = other1.attr;
  __isset = other1.__isset;
  return *this;
}
void ThriftAssoc::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "ThriftAssoc(";
  out << "srcId=" << to_string(srcId);
  out << ", " << "dstId=" << to_string(dstId);
  out << ", " << "atype=" << to_string(atype);
  out << ", " << "timestamp=" << to_string(timestamp);
  out << ", " << "attr=" << to_string(attr);
  out << ")";
}


ThriftEdgeUpdatePtr::~ThriftEdgeUpdatePtr() throw() {
}


void ThriftEdgeUpdatePtr::__set_shardId(const int64_t val) {
  this->shardId = val;
}

void ThriftEdgeUpdatePtr::__set_offset(const int64_t val) {
  this->offset = val;
}

uint32_t ThriftEdgeUpdatePtr::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->shardId);
          this->__isset.shardId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->offset);
          this->__isset.offset = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t ThriftEdgeUpdatePtr::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("ThriftEdgeUpdatePtr");

  xfer += oprot->writeFieldBegin("shardId", ::apache::thrift::protocol::T_I64, 1);
  xfer += oprot->writeI64(this->shardId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("offset", ::apache::thrift::protocol::T_I64, 2);
  xfer += oprot->writeI64(this->offset);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ThriftEdgeUpdatePtr &a, ThriftEdgeUpdatePtr &b) {
  using ::std::swap;
  swap(a.shardId, b.shardId);
  swap(a.offset, b.offset);
  swap(a.__isset, b.__isset);
}

ThriftEdgeUpdatePtr::ThriftEdgeUpdatePtr(const ThriftEdgeUpdatePtr& other2) {
  shardId = other2.shardId;
  offset = other2.offset;
  __isset = other2.__isset;
}
ThriftEdgeUpdatePtr& ThriftEdgeUpdatePtr::operator=(const ThriftEdgeUpdatePtr& other3) {
  shardId = other3.shardId;
  offset = other3.offset;
  __isset = other3.__isset;
  return *this;
}
void ThriftEdgeUpdatePtr::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "ThriftEdgeUpdatePtr(";
  out << "shardId=" << to_string(shardId);
  out << ", " << "offset=" << to_string(offset);
  out << ")";
}


ThriftSrcAtype::~ThriftSrcAtype() throw() {
}


void ThriftSrcAtype::__set_src(const int64_t val) {
  this->src = val;
}

void ThriftSrcAtype::__set_atype(const int64_t val) {
  this->atype = val;
}

uint32_t ThriftSrcAtype::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->src);
          this->__isset.src = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->atype);
          this->__isset.atype = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t ThriftSrcAtype::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("ThriftSrcAtype");

  xfer += oprot->writeFieldBegin("src", ::apache::thrift::protocol::T_I64, 1);
  xfer += oprot->writeI64(this->src);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("atype", ::apache::thrift::protocol::T_I64, 2);
  xfer += oprot->writeI64(this->atype);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ThriftSrcAtype &a, ThriftSrcAtype &b) {
  using ::std::swap;
  swap(a.src, b.src);
  swap(a.atype, b.atype);
  swap(a.__isset, b.__isset);
}

ThriftSrcAtype::ThriftSrcAtype(const ThriftSrcAtype& other4) {
  src = other4.src;
  atype = other4.atype;
  __isset = other4.__isset;
}
ThriftSrcAtype& ThriftSrcAtype::operator=(const ThriftSrcAtype& other5) {
  src = other5.src;
  atype = other5.atype;
  __isset = other5.__isset;
  return *this;
}
void ThriftSrcAtype::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "ThriftSrcAtype(";
  out << "src=" << to_string(src);
  out << ", " << "atype=" << to_string(atype);
  out << ")";
}


RPQuery::~RPQuery() throw() {
}


void RPQuery::__set_path_queries(const std::vector<std::vector<int64_t> > & val) {
  this->path_queries = val;
}

void RPQuery::__set_recurse(const bool val) {
  this->recurse = val;
}

uint32_t RPQuery::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->path_queries.clear();
            uint32_t _size6;
            ::apache::thrift::protocol::TType _etype9;
            xfer += iprot->readListBegin(_etype9, _size6);
            this->path_queries.resize(_size6);
            uint32_t _i10;
            for (_i10 = 0; _i10 < _size6; ++_i10)
            {
              {
                this->path_queries[_i10].clear();
                uint32_t _size11;
                ::apache::thrift::protocol::TType _etype14;
                xfer += iprot->readListBegin(_etype14, _size11);
                this->path_queries[_i10].resize(_size11);
                uint32_t _i15;
                for (_i15 = 0; _i15 < _size11; ++_i15)
                {
                  xfer += iprot->readI64(this->path_queries[_i10][_i15]);
                }
                xfer += iprot->readListEnd();
              }
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.path_queries = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->recurse);
          this->__isset.recurse = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t RPQuery::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("RPQuery");

  xfer += oprot->writeFieldBegin("path_queries", ::apache::thrift::protocol::T_LIST, 1);
  {
    xfer += oprot->writeListBegin(::apache::thrift::protocol::T_LIST, static_cast<uint32_t>(this->path_queries.size()));
    std::vector<std::vector<int64_t> > ::const_iterator _iter16;
    for (_iter16 = this->path_queries.begin(); _iter16 != this->path_queries.end(); ++_iter16)
    {
      {
        xfer += oprot->writeListBegin(::apache::thrift::protocol::T_I64, static_cast<uint32_t>((*_iter16).size()));
        std::vector<int64_t> ::const_iterator _iter17;
        for (_iter17 = (*_iter16).begin(); _iter17 != (*_iter16).end(); ++_iter17)
        {
          xfer += oprot->writeI64((*_iter17));
        }
        xfer += oprot->writeListEnd();
      }
    }
    xfer += oprot->writeListEnd();
  }
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("recurse", ::apache::thrift::protocol::T_BOOL, 2);
  xfer += oprot->writeBool(this->recurse);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(RPQuery &a, RPQuery &b) {
  using ::std::swap;
  swap(a.path_queries, b.path_queries);
  swap(a.recurse, b.recurse);
  swap(a.__isset, b.__isset);
}

RPQuery::RPQuery(const RPQuery& other18) {
  path_queries = other18.path_queries;
  recurse = other18.recurse;
  __isset = other18.__isset;
}
RPQuery& RPQuery::operator=(const RPQuery& other19) {
  path_queries = other19.path_queries;
  recurse = other19.recurse;
  __isset = other19.__isset;
  return *this;
}
void RPQuery::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "RPQuery(";
  out << "path_queries=" << to_string(path_queries);
  out << ", " << "recurse=" << to_string(recurse);
  out << ")";
}


Path::~Path() throw() {
}


void Path::__set_src(const int64_t val) {
  this->src = val;
}

void Path::__set_dst(const int64_t val) {
  this->dst = val;
}

uint32_t Path::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->src);
          this->__isset.src = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->dst);
          this->__isset.dst = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t Path::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Path");

  xfer += oprot->writeFieldBegin("src", ::apache::thrift::protocol::T_I64, 1);
  xfer += oprot->writeI64(this->src);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("dst", ::apache::thrift::protocol::T_I64, 2);
  xfer += oprot->writeI64(this->dst);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Path &a, Path &b) {
  using ::std::swap;
  swap(a.src, b.src);
  swap(a.dst, b.dst);
  swap(a.__isset, b.__isset);
}

Path::Path(const Path& other20) {
  src = other20.src;
  dst = other20.dst;
  __isset = other20.__isset;
}
Path& Path::operator=(const Path& other21) {
  src = other21.src;
  dst = other21.dst;
  __isset = other21.__isset;
  return *this;
}
void Path::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Path(";
  out << "src=" << to_string(src);
  out << ", " << "dst=" << to_string(dst);
  out << ")";
}


RPQCtx::~RPQCtx() throw() {
}


void RPQCtx::__set_endpoints(const std::set<Path> & val) {
  this->endpoints = val;
}

uint32_t RPQCtx::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_SET) {
          {
            this->endpoints.clear();
            uint32_t _size22;
            ::apache::thrift::protocol::TType _etype25;
            xfer += iprot->readSetBegin(_etype25, _size22);
            uint32_t _i26;
            for (_i26 = 0; _i26 < _size22; ++_i26)
            {
              Path _elem27;
              xfer += _elem27.read(iprot);
              this->endpoints.insert(_elem27);
            }
            xfer += iprot->readSetEnd();
          }
          this->__isset.endpoints = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t RPQCtx::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("RPQCtx");

  xfer += oprot->writeFieldBegin("endpoints", ::apache::thrift::protocol::T_SET, 1);
  {
    xfer += oprot->writeSetBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->endpoints.size()));
    std::set<Path> ::const_iterator _iter28;
    for (_iter28 = this->endpoints.begin(); _iter28 != this->endpoints.end(); ++_iter28)
    {
      xfer += (*_iter28).write(oprot);
    }
    xfer += oprot->writeSetEnd();
  }
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(RPQCtx &a, RPQCtx &b) {
  using ::std::swap;
  swap(a.endpoints, b.endpoints);
  swap(a.__isset, b.__isset);
}

RPQCtx::RPQCtx(const RPQCtx& other29) {
  endpoints = other29.endpoints;
  __isset = other29.__isset;
}
RPQCtx& RPQCtx::operator=(const RPQCtx& other30) {
  endpoints = other30.endpoints;
  __isset = other30.__isset;
  return *this;
}
void RPQCtx::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "RPQCtx(";
  out << "endpoints=" << to_string(endpoints);
  out << ")";
}


