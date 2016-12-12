# DataDocExtractor

A specialized data scraper for structured documents. It was originally create to be used for a singular purpose, but it should offer some potential for generalized purposes.

## Overview

The DataDocExtractor is a tool for extracting data from structured documents. It is designed to be used in conjunction with a template document that contains the structure of the document to be scraped. The DataDocExtractor will then extract the data from the document and return it in a structured format.

The original use case for the DataDocExtractor was to extract data from thousands of of customer profiles that had been compiled over many years. The document was a templates that contained a table with cells that contained multiple items. The DataDocExtractor parses the data from each row and writes it to a mysql database.

## Document Support

The DataDocExtractor currently supports the following document types:
- doc
- docx
- odt

## Usage

This is not a full working copy. It is only the core of the DataDocExtractor. It is intended to be used as a library or a base for a more generalized scraper.

## Contact

If you'd like to contact me to get more information about the DataDocExtractor, you can reach me on GitHub or Twitter @Am0rfu5